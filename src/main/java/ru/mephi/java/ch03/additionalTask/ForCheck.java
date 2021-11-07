package ru.mephi.java.ch03.additionalTask;

import java.util.*;
import java.util.function.Consumer;


public class ForCheck {
    String string = "Sasha's string";

    public static int compareLength(String str1, String str2) {
        return str1.length() - str2.length();
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(15);
        integers.add(20);
        Consumer<Integer> consumer = ClassForCheck::lak;
        integers.forEach(consumer);
    }
   /* public static void main(String[] args) {
        List<String> str = new ArrayList<>(Arrays.asList("gfh", "fsffs", "fr", "fffdadsq", "f"));
        // Now with default
        // str.sort((x,y)->x.length() - y.length());
        // Then without default
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        Collections.sort(str, comparator);
        // Объект::Метод
        Consumer<String> consumer = System.out::println;
        str.forEach(consumer);


        ////////////////////////////3x3
        String str1 = "Lasha";
        String str2 = "Modern Lasha";
        // класс::статик метод
        Comparator<String> comp = ForCheck::compareLength;
        str.sort(comp);
        System.out.println(comp.compare(str1, str2));
        // объект::метод
        Integer operand = 5;
        ClassForCheck check = new ClassForCheck();
        InterForCheck inter = check::multiplyRandom;
        RandomPossibleInteger.print(operand, inter);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i+1);
        }
        Consumer<Integer> consumer1 = System.out::println;
        System.out.println("Before sort");
        arrayList.forEach(consumer1);
        Comparator<Integer> comparator1 = check::likeComparator;
        arrayList.sort(comparator1);
        System.out.println("After sort");
        arrayList.forEach(consumer1);

    }*/
}
