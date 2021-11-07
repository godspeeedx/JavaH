package ru.mephi.java.ch01.task01;
/*
Напишите программу, вводящую целочисленное значение и выводящую его
в двоичной, восьмеричной и шестнадцатеричной форме. Организуйте вывод
обратного значения в виде шестнадцатеричного числа с плавающей точкой.
 */
import java.util.Scanner;

public class InputInt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input integer :");
       int number = in.nextInt();
        System.out.printf("16 : %x \n", number);
        System.out.printf("8 : %o \n", number);
        String str = Integer.toString(number,2);
        System.out.printf("2: %s\n", str);
        double inverse = 1.0/number;
        System.out.printf("Inverse: %f", inverse);

    }
}
