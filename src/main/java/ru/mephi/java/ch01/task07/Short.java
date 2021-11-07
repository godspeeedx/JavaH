package ru.mephi.java.ch01.task07;
/*
Напишите программу, вводящую два числа в пределах от 0 до 65535, сохраня-
ющую их в переменных типа short и вычисляющую их сумму, разность, про-
изведение, частное и остаток без знака, не преобразуя эти величины в тип int.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class Short {
    final static int OFF = 32768;

    public static void main(String[] args) {
        System.out.printf("Input 2 numbers, which equal from 0 to 65535\n");
        Scanner in = new Scanner(System.in);
        int first = in.nextInt();
        int second = in.nextInt();
        short new_number = (short) first;
        if (check(first, second) == false)
            System.out.println("At least one of your numbers is wrong");
        else {
            short number_first = intToShort(first);
            short number_second = intToShort(second);
            System.out.printf("Sum : %d\n", shortToInt(sum(number_first, number_second)));
            System.out.printf("Difference : %d\n", shortToInt(difference(number_first, number_second)));
            System.out.printf("Multiply : %d\n", shortToInt(multiply(number_first, number_second)));
            System.out.printf("Division : %d\n", shortToInt(division(number_first, number_second)));
            System.out.printf("Remains : %d\n", shortToInt(remains(number_first, number_second)));
        }
    }

    public static short intToShort(int number) {
        number -= OFF;
        return (short) number;

    }

    public static int shortToInt(short number) {
        return (number + OFF);
    }

    public static boolean check(int first, int second) {
        if (first > 65535 || first < 0) return false;
        if (second > 65535 || second < 0) return false;
        return true;

    }

    public static short sum(short first, short second) {
        int number_sum = first + second + 2 * OFF; // перешли к начанным данным от 0 до 65
        if (number_sum > 65535 || number_sum < 0) {
            System.out.println("Sum : overflow");
            return 0;
        }
        return (short) (number_sum - OFF);
    }

    public static short difference(short first, int second) {
        int dif = (first - second);
        if (dif > 65535 || dif < 0) {
            System.out.println("Difference : overflow");
            return 0;
        }
        return (short) (dif - OFF);
    }

    public static short multiply(short first, short second) {
        long mult = (first + OFF) * (second + OFF);
        if (mult > 65535) {
            System.out.println("Multiply : overflow");
            return 0;
        }
        return (short) (mult - OFF);

    }

    public static short division(short first, short second) {
        if (second == 0) return 0;
        int div = (first + OFF) / (second + OFF);
        if (div > 65535) {
            System.out.println("Division : overflow");
            return 0;
        }
        return (short) (div - OFF);
    }

    public static short remains(short first, short second) {
        if (second == 0) return 0;
        int remain = (first + OFF) % (second + OFF);
        if (remain > 65535) {
            System.out.println("Remains : overflow");
            return 0;
        }
        return (short) (remain - OFF);
    }

}
