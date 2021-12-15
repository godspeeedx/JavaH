package ru.mephi.java.ch06.task03;

public class Test {
    public static void main(String[] args) {
        Table<Integer, String> tab = new Table<>();
        tab.setValue(3, "sdf");
        tab.setValue(6, "sdf");
        tab.setValue(8, "sdf");
        System.out.println( tab.getValue(3));
        System.out.println(tab.getValue(8));
        tab.getValue(2);
        tab.deleteKey(3);
    }
}
