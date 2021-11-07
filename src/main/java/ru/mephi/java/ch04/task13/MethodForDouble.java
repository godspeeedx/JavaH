package ru.mephi.java.ch04.task13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.DoubleFunction;

public class MethodForDouble {
    public static void printWithMethod(Method method, double lowerBound, double upperBound, double stepSize)
            throws IllegalAccessException, InvocationTargetException {
        if (method == null || !Modifier.isStatic(method.getModifiers())) {
            throw new IllegalArgumentException();
        }
        System.out.println("Method: " + method.getDeclaringClass().getCanonicalName() + "." + method.getName());
        System.out.println(method.getDeclaringClass().getCanonicalName() + "." + method.getName());
        for (double value = lowerBound; value <= upperBound; value += stepSize) {
            Object result = method.invoke(method.getDeclaringClass(), value);
            System.out.println("Value: " + value + " -> result " + result);
        }
    }


    public static void printWithDoubleFunc(DoubleFunction<Object> method, double lowerBound, double upperBound, double stepSize)
    {
        System.out.println("DoubleFunction<Object>");
        for (double value = lowerBound; value <= upperBound; value += stepSize) {
            Object result = method.apply(value);
            System.out.println("Value: " + value + " -> result " + result);
        }

    }
}
