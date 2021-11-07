package ru.mephi.java.ch01.task08;

import java.util.Scanner;

/*
Напишите программу, вводящую символьную строку и выводящую все ее не-
пустые подстроки.
 */

public class StringSubstring {
    public static void main(String[] args) {
        System.out.print("Enter string : \n");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().trim();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                for (int j = str.length(); i < j; j--) {
                    if(str.charAt(j - 1) != ' ') {
                        System.out.print(str.substring(i, j));
                        System.out.println();
                    }
                }
            }
        }
        /*for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' ) {
                if (i - 1 >= 0 & str.charAt(i-1) != ' ')
                System.out.printf("\n");
            }
            else System.out.print(str.charAt(i));
        }

        StringBuilder str2 = new StringBuilder(str.trim());


        String[] new_strs = str2.toString().split("\\s+");
        System.out.println(new_strs.length);
        System.out.printf("non-empty substrings of the entered string %s", Arrays.toString(new_strs));*/

    }
}
