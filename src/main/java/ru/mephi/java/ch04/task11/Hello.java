package ru.mephi.java.ch04.task11;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Hello {
    public static void print() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InvocationTargetException {
        Class<?> clazz = Class.forName("java.lang.System");
        Field field = clazz.getDeclaredField("out");
        field.getType().getMethod("println", String.class)
                .invoke(System.out, "Hello, World!!!");
    }
}

