package ru.mephi.java.ch01.task06;
/*
Напишите программу, вычисляющую факториал п ! = 1 х 2 * . . . х п, исполь-
зуя класс BigInteger. Вычислите факториал числа 1000.
 */

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        BigInteger result = factorial(1000);
        System.out.println(result);
    }

    public static BigInteger factorial(int num) {
        BigInteger fact = new BigInteger("1");
        if (num < 0) {
            fact = BigInteger.valueOf(0);
        } else{
            BigInteger buf;
            for (int i = 1; i < num + 1; i++) {
                buf = BigInteger.valueOf(i);
                fact = fact.multiply((buf));
            }
        }

        return fact;
    }
}
