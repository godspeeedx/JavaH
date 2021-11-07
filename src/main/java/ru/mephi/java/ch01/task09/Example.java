package ru.mephi.java.ch01.task09;
/*
В разделе 1.5.3 был приведен пример сравнения двух символьных строк s и t
при вызове метода s . equals (t), но не с помощью операции s != t. Придумай-
те другой пример, в котором не применяется метод substring ().
 */
public class Example {

    public static void main(String[] args) {
        String a = "Ма";
        String b = "ма";
        String p = a + b;
        String d = "Мама";
        System.out.println( p == d);
        System.out.println( p.equals(d));
    }
}
