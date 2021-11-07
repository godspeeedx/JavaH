package ru.mephi.java.ch01.task11;
/*
Напишите программу, вводящую текстовую строку и выводящую все символы,
не представленные в коде ASCII, вместе с их значениями в Юникоде.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class WithoutASCII {
    public static void main(String[] args) {

        System.out.println("Enter an arbitrary string");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        ArrayList<Integer> ascii = new ArrayList<Integer>();
        ArrayList<String> chars = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            if ((int) str.charAt(i) > 127) {
                ascii.add((int) str.charAt(i));
                chars.add(str.substring(i, i + 1));
            }
        }
        for (int i = 0; i < ascii.size(); i++) {
            System.out.printf("char %s,  Unicode %d\n", chars.get(i), ascii.get(i));
        }

    }
}
