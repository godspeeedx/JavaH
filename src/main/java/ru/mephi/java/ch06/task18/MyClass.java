package ru.mephi.java.ch06.task18;

import java.util.Arrays;

public class MyClass {
    public static void main(String[] args) {
        //CustomArrays.repeat(10, 42, int[]::new);
        System.out.println(Arrays.toString(Arr.repeat(10, 42, Integer[]::new)));
    }
}
