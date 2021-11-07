package ru.mephi.java.ch04.task12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MesuarementEfficiency {
    public static void sayHello20000Times(){
        for(int i=0;i<20000;i++) {
            System.out.println("Hello,people!");
        }
    }
    public static void sayHelloReflection20000Times() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for(int i=0;i<20000;i++) {
            Method m = System.out.getClass().getDeclaredMethod("println", String.class);
            m.invoke(System.out, "Hello,people!");
        }
    }
}
