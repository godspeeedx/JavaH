package ru.mephi.java.ch06.AdditionalTask;

import java.lang.reflect.Field;

public class ClassFind {
    public static void main(String[] args) {
        InjectPoint injectPoint = new InjectPoint();
        method(injectPoint, "n");
    }
    public static void method(Object obj, String field){
        Class<?> cl = obj.getClass();
        try {
            Field field1 = cl.getDeclaredField(field);
            System.out.println(field1.getGenericType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
