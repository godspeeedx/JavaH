package ru.mephi.java.ch02.task08;

import java.util.Scanner;

/*
В предыдущих упражнениях для предоставления конструкторов и методов по-
лучения из класса P o in t пришлось писать часто повторяющийся код. В боль-
шинстве ИСР имеются средства, упрощающие написание повторяющегося ша-
блонного кода. Имеются ли такие средства в применяемой вами ИСР?
 */
public class LiveTamplates {
//psvm
public static void main(String[] args) {
    //sout
    System.out.println();
    //fori
    for (int i = 0; i < 10; i++) { // создаётся цикл фор, 10 добавлял сам

    }
   // St
    String local = "Moscow";
    // также можно посмотреть создавать свои шаблоны Tools-> Save as Live Tamplate
    // ScIn
    Scanner in = new Scanner(System.in);
    // ssss
    System.out.println("Введите имя");
    String name = in.nextLine();
    System.out.println("Введите фамилию");
    String  surname = in.nextLine();
}
}
