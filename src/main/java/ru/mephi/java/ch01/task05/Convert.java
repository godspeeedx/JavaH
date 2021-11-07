package ru.mephi.java.ch01.task05;
/*
Что произойдет, если привести числовое значение типа double к значению
типа int, которое больше самого большого значения типа int? Попробуйте
сделать это.
 */
public class Convert {
    public static void main(String[] args) {
        double x = 55555555555.0;
        int z = (int) x;
        System.out.println(z);
    }
}
