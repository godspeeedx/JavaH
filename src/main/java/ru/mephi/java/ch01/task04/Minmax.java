package ru.mephi.java.ch01.task04;
/*
Напишите программу, выводящую наименьшее и наибольшее положитель-
ные значения типа double. Подсказка: воспользуйтесь методом Math.nextUp ()
из прикладного программного интерфейса Java API.
 */
public class Minmax {
    public static void main(String[] args) {
        double d = 0.0;
        System.out.println(Math.nextUp(d));
        System.out.println(Math.nextDown(Double.POSITIVE_INFINITY));

    }
}
