package ru.mephi.java.ch06.extraTask.heapPollution;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        Entry<String, Integer>[] es2 = new Entry[5];
        ((Object[]) es2)[0] = new Entry<String, String>("ds",""); // heap pollution
    }
}
