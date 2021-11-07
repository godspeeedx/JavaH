package ru.mephi.java.ch04.task12;

import java.lang.reflect.InvocationTargetException;

public class Tester12 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        long nanoStartTime = System.nanoTime();
        long millisStartTime = System.currentTimeMillis();
        MesuarementEfficiency.sayHello20000Times();
        long nanoEndTime = System.nanoTime();
        long millisEndtime = System.currentTimeMillis();

        long nanoStartTimeReflect = System.nanoTime();
        long millisStartTimeReflect = System.currentTimeMillis();
        MesuarementEfficiency.sayHelloReflection20000Times();
        long nanoEndtimeReflect = System.nanoTime();
        long millisEndTimeReflect = System.currentTimeMillis();

        System.out.println("Time taken in nano seconds : " + (nanoEndTime - nanoStartTime));
        System.out.println("Time taken in milli seconds: " + (millisEndtime - millisStartTime));
        System.out.println("Time taken in nano seconds with reflection: " + (nanoEndtimeReflect - nanoStartTimeReflect));
        System.out.println("Time taken in milli seconds with reflection: " + (millisEndTimeReflect - millisStartTimeReflect));
    }
}
