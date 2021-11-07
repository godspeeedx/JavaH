package ru.mephi.java.ch04.task08;

import java.util.function.Function;

public class PrintName {
    public static void printNameOfClasses(Class a, Class b, Class c, Class d, Function<Class, String> func) {
        System.out.println(func.apply(a));
        System.out.println(func.apply(b));
        System.out.println(func.apply(c));
        System.out.println(func.apply(d));
    }
}
