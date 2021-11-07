package ru.mephi.java.ch02.task10;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {
    public static Random rand = new Random();
   /* public static void main(String[] args) {
        int[] arrayInt = {4,52,42,124,12,324,12321,12,42,51};
        System.out.println(RandomNumbers.randomElement(arrayInt));
        ArrayList<Integer> arrayListInt = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            arrayListInt.add(i);

        }
        System.out.println(RandomNumbers.randomElement(arrayListInt));
    }*/

    public static int randomElement (ArrayList<Integer> arrayInt){
        int numb = rand.nextInt(arrayInt.size());
        return arrayInt.get(numb);
    }
    public static int randomElement (int[] arrayInt){
        int numb = rand.nextInt(arrayInt.length);
        return arrayInt[numb];
    }

}
