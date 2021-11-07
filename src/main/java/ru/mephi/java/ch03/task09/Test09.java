package ru.mephi.java.ch03.task09;

public class Test09 {
    public static void main(String[] args) {
        Runnable run1 = ()->{
            for (int i = 0; i < 15; i++) {
                System.out.println("Hello World");
            }
        } ;
        Runnable run2 = ()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Goodbye World");
            }
        } ;
        Runnable run3 = ()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Everybody Hands up ");
            }
        } ;
        Runnable run4 = ()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Everybody Slow down ");
            }
        } ;
       RunThread.runTogether(run1,run2);
       RunThread.runInOrder(run3,run4);

    }

}
