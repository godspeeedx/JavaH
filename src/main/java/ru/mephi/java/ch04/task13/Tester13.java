package ru.mephi.java.ch04.task13;

import java.lang.reflect.InvocationTargetException;

public class Tester13 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InvocationTargetException {
        // передаём method
        MethodForDouble.printWithMethod(Math.class.getMethod("sqrt", double.class), 1,9, 2);
        System.out.println();
        MethodForDouble.printWithMethod(Double.class.getMethod("toHexString", double.class), 1,9, 2);
        System.out.println();

        // передаём DoubleFunction<Object>
        MethodForDouble.printWithDoubleFunc(Math::sqrt, 10,20, 1);
        System.out.println();
        MethodForDouble.printWithDoubleFunc(Double::toHexString, 10,20, 1);
        System.out.println();
    }
}
