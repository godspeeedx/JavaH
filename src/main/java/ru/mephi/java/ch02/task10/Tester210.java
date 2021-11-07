package ru.mephi.java.ch02.task10;

import java.util.ArrayList;

public class Tester210 {
    public static void main(String[] args) {
        int[] arrayInt = {4,52,42,124,12,324,12321,12,42,51};
        System.out.println(RandomNumbers.randomElement(arrayInt));
        ArrayList<Integer> arrayListInt = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            arrayListInt.add(i);

        }
        System.out.println(RandomNumbers.randomElement(arrayListInt));
    }

}
