package ru.mephi.java.ch01.task14;

import java.util.ArrayList;
import java.util.Scanner;

public class MagicSquare {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> square = magicSquare();
        if (checkSquare(square) == false)
            System.out.println("It isn't a square");
        else {
            if (magicCheckSquare(square) == true)
                System.out.println("It's a magic square");
            else
                System.out.println("It isn't a magic square");
        }


    }

    public static ArrayList<ArrayList<Integer>> magicSquare() {
        System.out.printf("Enter strings of numbers for massive\n If you want to stop the process enter empty string\n");
        ArrayList<String> str = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        for (; ; ) {
            String buf = in.nextLine();
            String buf2 = buf.trim();
            if (buf2.equals("")) break;
            str.add(buf2);
        }
        if (str.size() == 0) return null;
        ArrayList<ArrayList<Integer>> magic_square = new ArrayList<>();
        for (int i = 0; i < str.size(); i++) {
            String[] str_split = str.get(i).split("\\s+");
            ArrayList<Integer> num_of_str = new ArrayList<Integer>();
            for (int j = 0; j < str_split.length; j++) {
                num_of_str.add(Integer.parseInt(str_split[j]));
            }
            magic_square.add(num_of_str);
        }


        return magic_square;
    }

    public static boolean checkSquare(ArrayList<ArrayList<Integer>> magic_square) {
        if (magic_square == null) return false;
        for (int i = 0; i < magic_square.size(); i++)
            if (magic_square.size() != magic_square.get(i).size())
                return false;
        return true;
    }

    public static boolean magicCheckSquare(ArrayList<ArrayList<Integer>> magic_square) {
        if (magic_square == null)
            return false;
        if (checkSquare(magic_square) == false)
            return false;
        int reference_sample = 0;
        for (int i = 0; i < magic_square.size(); i++)
            reference_sample += magic_square.get(0).get(i);
        for (int i = 1; i < magic_square.size(); i++) { // проверка столбцов и строк
            int baf_value_str = 0;
            int baf_value_column = 0;
            for (int j = 0; j < magic_square.size(); j++) {
                baf_value_str += magic_square.get(i).get(j);
                baf_value_column += magic_square.get(j).get(i);
            }
            if (baf_value_column != reference_sample || baf_value_str != reference_sample)
                return false;
        }
        int first_diagonal = 0;
        int second_diagonal = 0;
        for (int i = 0; i < magic_square.size(); i++) {
            first_diagonal += magic_square.get(i).get(i);
            second_diagonal += magic_square.get(i).get((magic_square.size() - 1) - 1);
        }
        if (first_diagonal != reference_sample || second_diagonal != reference_sample)
            return false;

        return true;
    }



   /* public static void printTraingle(ArrayList<ArrayList<Integer>> triangle_pascal) {
        for (int i = 0; i < triangle_pascal.size(); i++) {
            for (int j = 0; j < triangle_pascal.get(i).size(); j++) {
                System.out.printf("%4d", triangle_pascal.get(i).get(j));
            }
            System.out.println();
        }
    }*/
}
