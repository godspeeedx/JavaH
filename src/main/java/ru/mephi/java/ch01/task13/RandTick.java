package ru.mephi.java.ch01.task13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandTick {
    public static void main(String[] args) {
        ArrayList<Integer> spisok = new ArrayList<>();
        int end = 49;
        for (int i = 1; i < end + 1; i++) {
            spisok.add(i);
        }
        int size = 6;
        int[] ticket = new int[size];
        Random number = new Random();
        for (int i = 0; i < size; i++) {
            int index = number.nextInt(spisok.size());
            ticket[i] = spisok.get(index);
            spisok.remove(index);

        }
        System.out.println(Arrays.toString(ticket));
        Arrays.sort(ticket);
        System.out.println(Arrays.toString(ticket));
    }
}
