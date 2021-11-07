/*
Проанализируйте метод n e x t l n t () из класса S c a n n e r. Является ли он методом
доступа или модифицирующим методом и почему? А что можно сказать о
методе n e x t l n t () из класса Random ?
 */
package ru.mephi.java.ch02.task02;

import java.util.Random;
import java.util.Scanner;

public class CheckMethods {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(in);
        int a = in.nextInt();
        System.out.println(in);
        Random generator = new Random();
        System.out.println(generator);
        int b = generator.nextInt();
        System.out.println(b);
        System.out.println(generator);
    }
}
