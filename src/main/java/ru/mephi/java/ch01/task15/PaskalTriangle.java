package ru.mephi.java.ch01.task15;

import java.util.ArrayList;
import java.util.Scanner;

public class PaskalTriangle {
    public static void main(String[] args) {
        System.out.println("Enter a length of Pascal's Triangle");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        ArrayList<ArrayList<Integer>> triangle_pascal = pascalTriangle(number);
        printTraingle(triangle_pascal);
        printTraingle(pascalTriangle2(number));

    }

    public static ArrayList<ArrayList<Integer>> pascalTriangle(int number) {
        ArrayList<ArrayList<Integer>> triangle_pascal = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            ArrayList<Integer> string = new ArrayList<Integer>();
            for (int k = 0; k < i + 1; k++) string.add(0);
            string.set(0, 1);
            string.set(i, 1);
            for (int j = 1; j < i; j++) {
                string.set(j, triangle_pascal.get(i - 1).get(j - 1) + triangle_pascal.get(i - 1).get(j));
            }
            triangle_pascal.add(string);

        }
        return triangle_pascal;
    }

    public static ArrayList<ArrayList<Integer>> pascalTriangle2(int number) {
        ArrayList<ArrayList<Integer>> triangle_pascal = new ArrayList<>();
        for (int i = 0; ; i++) {
            ArrayList<Integer> string = new ArrayList<Integer>();
            for (int k = 0; k < i + 1; k++) string.add(0);
            string.set(0, 1);
            string.set(i, 1);
            for (int j = 1; j < i; j++) {
                string.set(j, triangle_pascal.get(i - 1).get(j - 1) + triangle_pascal.get(i - 1).get(j));
            }
            triangle_pascal.add(string);
            boolean check = false;
            for (int j = 0; j < string.size(); j++) {
                if (string.get(j) >= number) {
                    check = true;
                    break;
                }

            }
            if (check == true)
                break;
        }
        return triangle_pascal;
    }

    public static void printTraingle(ArrayList<ArrayList<Integer>> triangle_pascal) {
        for (int i = 0; i < triangle_pascal.size(); i++) {
            for (int j = 0; j < triangle_pascal.get(i).size(); j++) {
                System.out.printf("%4d", triangle_pascal.get(i).get(j));
            }
            System.out.println();
        }
    }
}
