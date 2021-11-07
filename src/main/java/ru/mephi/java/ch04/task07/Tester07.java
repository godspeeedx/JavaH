package ru.mephi.java.ch04.task07;

public class Tester07 {
    public static void main(String[] args) {
        System.out.println(Colors.getRed());
        System.out.println(Colors.getBlue());
        for (Colors m: Colors.values()) {
            System.out.println(m);
        }
    }
}
