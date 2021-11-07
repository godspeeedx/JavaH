package ru.mephi.java.ch04.addTask;

import ru.mephi.java.ch04.ClassesForTest.ClassCharacter;
import ru.mephi.java.ch04.task09.Class1;

import java.io.IOException;
import java.lang.reflect.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

//
public class SerializeRef {
    private static String[] wrappers = {"java.lang.Boolean",
            "java.lang.Integer", "java.lang.Double", "java.lang.Character"};


    /*
    класс должен быть JavaBean
    конструктор без аргументов

     */
    public static byte[] serialize(Object object) {
        if (object == null)
            return null;
        return SerializeRef.toString(object).getBytes(StandardCharsets.UTF_8);
    }

    public static String stringToString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"");
        stringBuilder.append(str.length());
        stringBuilder.append(" ");
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
        }
        stringBuilder.append("\"");
       // System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static Object deSerialize(byte[] code) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (code == null) return null;
        Charset charset = StandardCharsets.UTF_8;
        String str = new String(code, charset);
        //  System.out.println(str); //--------------------для отладки

        int i = 0;
        String cls = "";
        while (str.charAt(i) != ' ') {
            cls += str.charAt(i);
            i++;
        }
        i += 2;
        //System.out.println(cls);
        for (String wrapper : wrappers) {
            if (wrapper.equals(cls)) {
                return setWrapperWithIndex(cls, str, i);
            }
        }
        Class<?> obj = Class.forName(cls);
        Object obj2 = obj.getDeclaredConstructor().newInstance();
        setRecursion(obj2, str, i);
        return obj2;
    }

    // обработка обёрток
    public static Object setWrapperWithIndex(String name, String data, int i) {
        while (data.charAt(i) != '=') {
            i++;
        }
        i++;
        StringBuilder stringBuilder = new StringBuilder();
        while (data.charAt(i) != ']') {
            stringBuilder.append(data.charAt(i));
            i++;
        }

        if (name.equals(wrappers[0])) {
            return Boolean.valueOf(stringBuilder.toString());
        } else if (name.equals(wrappers[1])) {
            return Integer.parseInt(stringBuilder.toString());
        } else if (name.equals(wrappers[2])) {
            return Double.parseDouble(stringBuilder.toString());
        } else if (name.equals(wrappers[3])){
            return  Character.valueOf(stringBuilder.toString().charAt(0));
        }

        return null;
    }

    public static Object setWrapper(String name, String data) {

        if (name.equals(wrappers[0])) {
            return Boolean.valueOf(data);
        } else if (name.equals(wrappers[1])) {
            return Integer.parseInt(data);
        } else if (name.equals(wrappers[2])) {
            return Double.parseDouble(data);
        }else if (name.equals(wrappers[3])){
            return  Character.valueOf(data.charAt(0));
        }

        return null;
    }

    /*
       System.out.print("Enter string : \n");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                for (int j = str.length(); i < j; j--) {
                    if(str.charAt(j - 1) != ' ') {
                        System.out.print(str.substring(i, j));
                        System.out.println();
                    }
                }
            }
        }
     */
    public static void setOneFilled(Object obj, String nameField, Object data) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String str = "set" + nameField.substring(0, 1).toUpperCase()
                + nameField.substring(1, nameField.length());
        // System.out.println(data.getClass().getName());
        Method method = obj.getClass().getMethod(str, data.getClass());
        method.invoke(obj, data);

    }

    public static void setOneFilled(Object obj, String nameField, String data) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        String str = "set" + nameField.substring(0, 1).toUpperCase()
                + nameField.substring(1, nameField.length());
        Field[] fields = obj.getClass().getDeclaredFields();
        Field m = null;
        for (Field field : fields) {
           // System.out.println(field.getName());
            if (field.getName().toString().equals(nameField)) {
                m = field;
                break;
            }
        }
        //public int x
        Class<?> c = m.getType();

        Class obj2 = obj.getClass();
        Method method = obj2.getMethod(str, c); // Integer.class

        method.invoke(obj, Converter.convert(c.getSimpleName(), data));  // data - 4.890, "dklda", boolean

    }

    public static int setRecursion(Object obj, String str, int i) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        int j = i;
        StringBuilder builderField = new StringBuilder("");
        StringBuilder builderData = new StringBuilder("");
        while (str.charAt(j - 1) != ']') { // пока не закроется класс
            if (str.charAt(j) != ',' && str.charAt(j) != ' ' && str.charAt(j) != '=' && str.charAt(j) != ']') {
                // находим название поля
                if (str.charAt(j) == '[')
                    j += 2;
                builderField.append(str.charAt(j));
                j++;
                //continue;
            } else if (str.charAt(j) == '=') {
                // находим данные поля или
                //arrayListField.add(builderField.toString());

                j++;
                // переводить строку так, чтобы указывалась её длина после ковычек, тогда мы сможем не запоминать
                if (str.charAt(j) == '\"' && str.charAt(j + 1) != ',') {
                    j++;
                    StringBuilder strLength = new StringBuilder();
                    while (str.charAt(j) != ' ') {
                        strLength.append(str.charAt(j));
                        j++;
                    }
                    int length = Integer.parseInt(strLength.toString());
                    j++;
                    for (int p = 0; p < length; p++) {
                        builderData.append(str.charAt(j));
                        j++;
                    }
                    j++;
                } else if (str.charAt(j) == '\'') {
                    j++;
                    builderData.append(str.charAt(j));
                    j += 2;
                } else {
                    while (str.charAt(j) != ',' && str.charAt(j) != ' ' && str.charAt(j) != ']') {
                  /*  if (str.charAt(j) == '\\') {
                        builderData.append(str.charAt(j));
                        builderData.append(str.charAt(j+1));
                        j+=2;
                    } else*/
                        builderData.append(str.charAt(j));
                        j++;

                        // continue;
                    }
                }
                // заполнить поле класса рабадакинг
            } else if (str.charAt(j) == ',' || str.charAt(j) == ']') {

                if (builderData.length() != 0) {
                    SerializeRef.setOneFilled(obj, builderField.toString(), builderData.toString());
                }
                builderData.setLength(0);
                builderField.setLength(0);
                j++;
            } else if (str.charAt(j) == ' ') {
                StringBuilder stringBuilder = new StringBuilder();
                for (String wrapper : wrappers) {
                    if (wrapper.equals(builderData.toString())) {
                        while (str.charAt(j) != '=')
                            j++;

                        j++;
                        if (str.charAt(j) == '\'') {
                            j++;
                            stringBuilder.append(str.charAt(j));
                            j += 2;
                        } else {
                            while (str.charAt(j) != ']') {
                                stringBuilder.append(str.charAt(j));
                                j++;
                            }
                        }
                        j++;
                        break;
                    }
                }
                Object newObj2;
                if (stringBuilder.length() != 0) {
                    newObj2 = setWrapper(builderData.toString(), stringBuilder.toString());
                } else {
                    Class<?> newObj = Class.forName(builderData.toString());
                    newObj2 = newObj.getDeclaredConstructor().newInstance();
                    j += 2;
                    j = setRecursion(newObj2, str, j);
                }
                SerializeRef.setOneFilled(obj, builderField.toString(), newObj2);
                builderData.setLength(0);
                builderField.setLength(0);
                if (str.charAt(j) == ',')
                    j++;

            }

        }
        // сделать случай когда класс в классе
        return j;
    }

    public static String stringToChar(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("'");
        stringBuilder.append(str.charAt(0));
        stringBuilder.append("'");
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static String toString(Object obj) {

        Class cl = obj.getClass();
        if (cl == String.class) return stringToString((String) obj);
        //if (cl == Character.class)
        //    return stringToChar((String) obj);
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) r += ",";
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
            return r + "}";
        }

        String r = cl.getName();
        // inspect the fields of this class and all superclasses
        do {
            if (cl.getName() == Object.class.getName()) break;
            r += " [";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            // get the names and values of all fields
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) {
                            if (t.getSimpleName().equals("char")) {
                                r += "'" + val + "'";
                            } else
                                r += val;
                        } else r += toString(val);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        } while (cl != null);

        return r;
    }

}
