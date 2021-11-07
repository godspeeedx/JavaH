package ru.mephi.java.ch02.task04;

public class Tester204 {
    public static void main(String[] args) {
        int first = 1;
        int second = 10;
        Integer first1 = 1;
        Integer second1 = 10;
        WorkWithInt.changeInt(first, second);
        System.out.println("After change: int first equals =" + first);
        System.out.println("After change: int second equals =" + second);
        WorkWithInt.changeInt(first1, second1);
        System.out.println("After change: int first equals =" + first1);
        System.out.println("After change: int second equals =" + second1);
        WorkWithInt.IntHolder x = new WorkWithInt.IntHolder(5);
        WorkWithInt.IntHolder y = new WorkWithInt.IntHolder(10);
        WorkWithInt.changeInt(x,y);
        System.out.println("Intholder x = " + x.getInteger());
        System.out.println("Intholder y = " + y.getInteger());
    }
}
