package ru.mephi.java.ch04.task09;

import java.lang.reflect.Field;

public class UnivToString {
    public static String toString(Object obj) throws IllegalAccessException {
        StringBuilder str = new StringBuilder();
        str.append(obj.getClass().getName());
        Class<?> aClass = obj.getClass();
        while (aClass != null) {
            for (Field f : aClass.getDeclaredFields()) {
                f.setAccessible(true);
                Object value = f.get(obj);
                str.append(", [").append(f.getName()).append(" = ").append(value).append("]");
            }
            aClass = aClass.getSuperclass();
        }

        return String.valueOf(str);
    }
}
