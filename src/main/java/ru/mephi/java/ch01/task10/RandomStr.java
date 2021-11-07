package ru.mephi.java.ch01.task10;
/*
Напишите программу, составляющую произвольную символьную строку из
букв и цифр, генерируя произвольное значение типа long и выводя его по ос-
нованию 36.
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomStr {
    public static void main(String[] args) {
        int num = lengthOfString();
        String str = createString(num);
        System.out.println(str);

    }


    public static int lengthOfString() {
        System.out.println("Enter long of the desired line");
        Scanner in = new Scanner(System.in);
        int i = 1;
        int num = 0;
        while (i < 2) {
            i++;
            String buf = in.nextLine();
            String buf2 = buf.trim();
            if (buf2.equals("")) {
                System.out.println("You haven't entered number. Pls do it again");
                i--;
            } else {
                num = Integer.parseInt(buf2);
            }
        }
        return num;
    }

    public static String createString(int num) {
        StringBuilder str = new StringBuilder("");
        int counter = 0;
        Random rand = new Random();
        for (int i = 0; ; i++) {
            long number = Math.abs(rand.nextLong());
            String buf = Long.toString(number, 36);
            counter += buf.length();
            if (counter < num) {
                str.append(buf);
            } else if (counter == num) {
                str.append(buf);
                break;
            } else {
                int difference = counter - num;
                str.append(buf.substring(0, buf.length() - difference));
                break;
            }

        }

        return str.toString();
    }


}


  /*
    public static ArrayList<String> createArray(int num) {
        ArrayList<String> str = new ArrayList<>();
        int counter = 0;
        Random rand = new Random();
        for (int i = 0; ; i++) {
            long number = rand.nextLong();
            str.add(Long.toString(number, 36));
            counter += str.get(i).length();
            if (counter >= num) {
                if (counter == num) {
                    break;
                }
                String buf = str.get(i);
                str.remove(i);
                int difference = counter - num;
                str.add(buf.substring(0, buf.length() - difference));
                break;
            }
        }
        return str;
    }

    private static void printStr(ArrayList<String> str) {

        for (String len : str) {
            System.out.printf(len);
        }

    }
    */