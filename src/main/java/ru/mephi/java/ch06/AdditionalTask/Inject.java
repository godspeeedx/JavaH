package ru.mephi.java.ch06.AdditionalTask;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Inject {
    /**
     * Check inject classes from "cls" to field "field" of Object o
     * check only classes with annotation TryInject
     *
     * @return true if it inject is possible
     */



    public static List<Class<?>> check(Object o, String field) throws NoSuchFieldException {
        // получаем все классы из пакета
        List<Class<?>> cls = ClassFinder.find("ru.mephi.java.ch06.AdditionalTask");
        //Лист с информацией о поле то есть, есть ли параметрирозованные типы, как они ограничены, как ограничения ограничены и тд
        ArrayList<LinkedListType> arrayList1 = ClassDeclaration.getDeclarationClass(o.getClass(), field);
        List<Class<?>> result = new ArrayList<>();
        for (Class<?> cl : Objects.requireNonNull(cls)) {
          //  System.out.println(cl.getSuperclass().toString());
            // Если это просто класс, то проверяем можно ли его прикастить
                if ((cl.getGenericSuperclass() instanceof Class)) {
                    //проверка на то, можно ли данный клас прикастить
                    if (checkClass(cl, arrayList1)) {
                        result.add(cl);
                    }
                } else {
                    // проверяем можно ли прикастить данный класс
                    Boolean resultFlag = checkParameterizedType(cl, arrayList1);
                    if (resultFlag == null) {
                        result.add(cl);
                    }else if (resultFlag) {
                        result.add(cl);
                    }
                }

        }
        return result;
    }

    // проверяем может ли наше поле ссылать на данный класс
    private static Boolean checkParameterizedType(Class<?> cls, ArrayList<LinkedListType> arrayList1) {
        Class<?> fieldClass = null;
        // Получаем родителя класса и кастим к параметрирезованному типу
        ParameterizedType type = (ParameterizedType) cls.getGenericSuperclass();
        if (type != null) {
            // Получаем тайп параметры
            Type[] types = type.getActualTypeArguments();
            // получаем начальное поле, то есть Класс переменной(без ограничений и тд)
            fieldClass = getFieldClass(null, arrayList1, 0);
            assert fieldClass != null;
            // проверка на то, можно ли к нашему классу прикастить что-то без ограничений
            if (checkUpperNotStrict(fieldClass, fieldClass.isAssignableFrom(cls))) return false;
            Class<?> parameter;
            // если можно продолжаем проверять дальше
            for (int i = 0; i < types.length; i++) {
                if (types[i] instanceof Class<?>) {
                    parameter = (Class<?>) types[i];
                    fieldClass = getFieldClass(fieldClass, arrayList1, i + 1);
                    if (!arrayList1.get(i + 1).isStrict()) {
                        // проверка можно ли прикастить
                        if (checkStrict(arrayList1, fieldClass, parameter, i)) return false;
                    } else {
                        if (!fieldClass.equals(parameter)) {
                            return false;
                        }
                    }
                    LinkedListType typeNext = arrayList1.get(i + 1).getNext();
                    if (!checkClassHierarchically(typeNext, parameter)) {
                        return false;
                    }
                } else if (types[i] instanceof ParameterizedType) {
                    return checkClassHierarchicallyParametrized(arrayList1, types, i);
                }
            }
        } else {
            return checkClass(cls, arrayList1);
        }
        //return true;
        return null;
    }


    private static Class<?> getFieldClass(Class<?> fieldClass, ArrayList<LinkedListType> arrayList1, int i2) {
        try {
            fieldClass = Class.forName(arrayList1.get(i2).getType());
        } catch (ClassNotFoundException e) {
            System.out.println("check getDeclarationClass");
        }
        return fieldClass;
    }


    private static boolean checkStrict(ArrayList<LinkedListType> arrayList1, Class<?> fieldClass, Class<?> parameter, int i) {
        if (arrayList1.get(i + 1).isUpLow())// Upper
        {
            return !fieldClass.isAssignableFrom(parameter);
        } else {
            return !parameter.isAssignableFrom(fieldClass);
        }
    }


    private static boolean checkClass(Class<?> cls, ArrayList<LinkedListType> arrayList1) {
        Class<?> fieldClass = getFieldClass(arrayList1.get(0));
        assert fieldClass != null;
        // Проверка на то, кастится ли класс cls к полю fieldClass
        return fieldClass.isAssignableFrom(cls);
    }

  // проверяем можно ли дальше присвоить, то есть все ограничения проверям
    private static boolean checkClassHierarchically(LinkedListType typeNext, Class<?> parameter) {
        if (typeNext != null) {
            Class<?> fieldClass = getFieldClass(typeNext);
            assert fieldClass != null;
            if (!typeNext.isStrict()) {
                if (typeNext.isUpLow())//Если верхняя граница
                {
                    // Можно ли прикастить
                    if (checkUpperNotStrict(fieldClass, fieldClass.isAssignableFrom(parameter))) return false;
                } else {
                    if (parameter.getSuperclass() != Object.class && parameter != Object.class) {
                        parameter = parameter.getSuperclass();
                    }
                    if (checkUpperNotStrict(fieldClass, parameter.isAssignableFrom(fieldClass))) return false;
                }
            } else {
                if (!fieldClass.equals(parameter)) {
                    return false;
                }
            }
            typeNext = typeNext.getNext();
            return checkClassHierarchically(typeNext, parameter);
        }
        return true;
    }

    private static boolean checkUpperNotStrict(Class<?> fieldClass, boolean assignableFrom) {
        assert fieldClass != null;
        return !assignableFrom;
    }

    private static boolean checkClassHierarchicallyParametrized(ArrayList<LinkedListType> typeNextArray
            , Type[] types, int i) {
        LinkedListType typeNext = typeNextArray.get(i + 1);
        Type type = types[i];
        if (typeNext != null) {
            Class<?> parameter = getParameter((ParameterizedType) type);
            Class<?> fieldClass = getFieldClass(typeNext);
            if (!typeNext.isStrict()) {
                if (checkNotStrictParameterized(typeNext, parameter, fieldClass)) return false;
            } else {
                assert fieldClass != null;
                if (!fieldClass.equals(parameter)) {
                    return false;
                }
            }
            typeNext = typeNext.getNext();
            type = getType(types, i, type);
            if (type instanceof ParameterizedType) {
                Boolean result = checkParameterizedType(typeNext, (ParameterizedType) type);
                if (result != null) return result;
            } else {
                return checkClassHierarchically(typeNext, (Class<?>) type);
            }
        }
        return true;
    }

    private static boolean checkNotStrictParameterized(LinkedListType typeNext, Class<?> parameter, Class<?> fieldClass) {
        if (typeNext.isUpLow())// Upper
        {
            assert fieldClass != null;
            assert parameter != null;
            return checkUpperNotStrict(parameter, fieldClass.isAssignableFrom(parameter));
        } else {
            assert parameter != null;
            assert fieldClass != null;
            return checkLow(parameter, fieldClass);
        }
    }

    private static Boolean checkParameterizedType(LinkedListType typeNext, ParameterizedType type) {
        Class<?> parameter;
        if (typeNext != null) {
            String description = type
                    .getRawType().getTypeName();
            parameter = null;
            try {
                parameter = Class.forName(description);
            } catch (ClassNotFoundException e) {
                System.out.println("check checkClassHierarchicallyParametrized");
            }
            return checkClassHierarchically(typeNext, parameter);
        }
        return null;
    }

    private static Type getType(Type[] types, int i, Type type) {
        if (types.length == i + 1) {
            type = ((ParameterizedType) type).getActualTypeArguments()[0];
        } else {
            type = types[++i];
        }
        return type;
    }

    private static boolean checkLow(Class<?> parameter, Class<?> fieldClass) {
        if (parameter.getSuperclass() != Object.class) {
            parameter = parameter.getSuperclass();
        }
        return checkUpperNotStrict(fieldClass, parameter.isAssignableFrom(fieldClass));
    }
    // возвращает поле класса
    private static Class<?> getFieldClass(LinkedListType typeNext) {
        Class<?> fieldClass = null;
        try {
            fieldClass = Class.forName(typeNext.getType());
        } catch (ClassNotFoundException e) {
            System.out.println("check getDeclarationClass");
        }
        return fieldClass;
    }

    private static Class<?> getParameter(ParameterizedType type) {
        String description = type.getRawType().getTypeName();
        Class<?> parameter = null;
        try {
            parameter = Class.forName(description);
        } catch (ClassNotFoundException e) {
            System.out.println("check checkClassHierarchicallyParametrized");
        }
        return parameter;
    }

    public static void main(String[] args) throws NoSuchFieldException {

        check(new InjectPoint(), "n").forEach(System.out::println);
    }
}
