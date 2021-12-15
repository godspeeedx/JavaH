package ru.mephi.java.ch06.task20;

import ru.mephi.java.ch03.task01.Employee;
import ru.mephi.java.ch06.extraTask.contrvar.Manager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public class MyClass {
    public static void main(String[] args) {

        Employee[] employees = new Employee[3];
        employees[0] = new Manager("dd", 2,2);
        employees[1] = new Employee(2);
        System.out.println(Arrays.toString(repeat(3,employees)));
        //System.out.println(Arrays.toString(repeat(2, List.of(1, 2, 3, 4, 5))));
    }

    // 20  не эффективно
    @SafeVarargs
    public static final <T> T[] repeat(int n, T... objs) {
        System.out.println(objs.getClass().arrayType().getName());
        T[] t = (T[]) Array.newInstance(objs.getClass(), n*objs.length);

        for (int i = 0; i < n*objs.length; i++){
            t[i] = objs[i%objs.length];
        }

        return t;
    }
}