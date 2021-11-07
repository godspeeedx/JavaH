package ru.mephi.java.ch03.task07;


import java.util.ArrayList;
import java.util.Comparator;

public class Test07 {
    public static void main(String[] args) {
        Lucky check = new Lucky();
        ArrayList<String> str = new ArrayList<>();
        str.add("A"); // (N/2)*N! // (1/(1/N*1/(N-1)*....)) = 1/(1/N!) = N!
        str.add("AB"); //
        str.add("ABC");
        str.add("ABCD");
        str.add("ABCDE");
        Comparator<String> comp = (String first, String second) -> Integer.compare(first.length(),second.length());
        int checke = check.luckySort(str, comp);
        for (int i = 0; i < str.size(); i++) {
            System.out.println(str.get(i));
        }
        System.out.println("Количество итераций " + checke);
    }
}
