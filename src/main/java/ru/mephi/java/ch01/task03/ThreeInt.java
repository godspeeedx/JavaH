package ru.mephi.java.ch01.task03;
/*
Напишите программу, вводящую три целочисленных значения и выводящую
самое большое из них, используя только условную операцию. Сделайте то же
самое с помощью метода Math.max ().
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ThreeInt {
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        System.out.println("Input three numbers of integer:");
        int[] numbers = new int[3];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = in.nextInt();
        }
        int max_int = numbers[0];
        if (max_int < numbers[1]) max_int = numbers[1];
        if (max_int < numbers[2]) max_int = numbers[2];
        System.out.printf("Max of integers : %d \n", max_int);
        System.out.printf("Max of integers : %d \n", Math.max(numbers[0], Math.max(numbers[1], numbers[2])));*/
        maxInteger(printInt());
    }

    public static void maxInteger(ArrayList<Integer> numbers) {
        int maxInt = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++){
            if(maxInt < numbers.get(i)) {
                maxInt = numbers.get(i);
            }
        }
        System.out.printf("Max of integers : %d \n", maxInt);
    }

    public static ArrayList<Integer> printInt() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter numbers\n If you want to stop the process enter empty string\n");
        for (; ; ) {
            boolean check = false;
            String buf = in.nextLine();
            String buf2 = buf.trim();
            if (buf2.equals("")) {
                if (numbers.size() < 2) {
                    check = true;
                    System.out.println("You have entered less than two numbers, pls enter again");
                    System.out.println("If you want to stop the process enter empty string");
                    for (int i = 0; i < numbers.size();)
                    {
                        numbers.remove(i);
                    }
                } else {
                    break;
                }
            }
            if (check == false) {
                numbers.add(Integer.parseInt(buf2));
            }
        }

        return numbers;
    }


}


