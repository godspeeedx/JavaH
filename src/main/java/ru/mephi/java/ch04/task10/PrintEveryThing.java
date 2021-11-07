package ru.mephi.java.ch04.task10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintEveryThing {
    public static void print(Object obj){
        System.out.print("Class name: ");
        Class<?> cl = obj.getClass();
        System.out.println(cl.getCanonicalName());
        while (cl != null) {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(
                        Modifier.toString(m.getModifiers()) + " " +
                                m.getReturnType().getCanonicalName() + " " +
                                m.getName() +
                                Arrays.toString(m.getParameters()));
            }
            cl = cl.getSuperclass();
        }
    }
}
