package ru.mephi.java.ch03.taskComporator;

import java.util.ArrayList;

public class TestForComparator {
    public static void sort(ArrayList<Integer> arrayList, ComparatorNew<Integer> comparatorNew) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = 0; j < arrayList.size() - 1 - i; j++) {
                if (comparatorNew.compare(arrayList.get(i), arrayList.get(i + 1)) > 0){
                    int buf = arrayList.get(i);
                    arrayList.set(i + 1, arrayList.get(i));
                    arrayList.set(i, buf);
                }

            }

        }
    }

    public static void print(ArrayList<Integer> arrayList){
        arrayList.forEach(System.out::println);
    }

}
