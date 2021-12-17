package ru.mephi.java.ch06.AdditionalTask;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClassDeclaration {

    public static ArrayList<LinkedListType> getDeclarationClass(Class clazz, String field) throws NoSuchFieldException {
        // получаем тайп параметры с границами класса
        Map<String, String> map = typeBounds(clazz);
        // получаем поле класса, которое ищем
        Field f = clazz.getDeclaredField(field);
        f.setAccessible(true);
        ArrayList<LinkedListType> arrayList = new ArrayList<>();
        arrayList.add(LinkedListType.setInitalParent(f.getType().getTypeName()));
       // System.out.println(f.getGenericType().toString());
        if (!(f.getGenericType() instanceof Class)) {
            // Получаем парамтреризованный тип, Например Pair<? extends Number>
            ParameterizedType parameterizedType = (ParameterizedType) f.getGenericType();
            String typeName;
            //System.out.println( Arrays.toString(parameterizedType.getActualTypeArguments()));
            //Смотрим массив его тайп параметров
            for (int j = 0; j != parameterizedType.getActualTypeArguments().length; j++) {
                typeName = parameterizedType.getActualTypeArguments()[j].getTypeName();
                // Тут надо проверить, чё происходит
                typeName = checkReplaceFromMap(map, typeName);
                if (parameterizedType.getActualTypeArguments()[j] instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) parameterizedType.getActualTypeArguments()[j];
                    arrayList.add(GetTypes.getLinkedListType(wildcardType, map));
                } else {
                    arrayList.add(new LinkedListType(typeName, true, true));
                }
            }
        }
        return arrayList;
    }


    private static Map<String, String> typeBounds(Class<?> cl) {
        String description = null;
        Map<String, String> result = null;
        // получаем тайп параметры класса
        TypeVariable<?>[] vars = cl.getTypeParameters();
        if (vars.length != 0) {
            result = new HashMap<>(vars.length);
            for (TypeVariable<?> var : vars) {
                Type[] bounds = var.getBounds();
                if (bounds[0] instanceof ParameterizedType) {
                    ParameterizedType p = (ParameterizedType) bounds[0];
                    Type[] typeArguments = p.getActualTypeArguments();
                    if (typeArguments[0] instanceof WildcardType) {
                        WildcardType t = (WildcardType) typeArguments[0];
                        Type[] upper = t.getUpperBounds();
                        Type[] lower = t.getLowerBounds();
                        if (lower.length > 0) {
                            description = lower[0].getTypeName();
                        } else if (upper.length > 0) {
                            description = upper[0].getTypeName();
                        }
                    }

                } else {
                    description = bounds[0].getTypeName();
                }
                result.put(var.getName(), description);
            }
        }
        return result;
    }


    private static String checkReplaceFromMap(Map<String, String> map, String original) {
        if (map != null) {
            Pattern pattern = null;
            Matcher matcher = null;
            for (String key : map.keySet()) {
                pattern = Pattern.compile("\\b" + key + "\\b");
                matcher = pattern.matcher(original);
                if (matcher.find()) {
                    original = matcher.replaceAll(map.get(key));
                    break;
                }
            }
        }
        return original;
    }

}