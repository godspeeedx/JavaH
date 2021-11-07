package ru.mephi.java.ch03.task13;

public class Test13 {
    public static void main(String[] args) {


        Runnable[] runs = new Runnable[3];
        runs[0] = ()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello");
            }
        };
        runs[1] = ()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("World");
            }
        };
        runs[2] = ()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Goodbye");
            }
        };
       Runnable runnable = RunsToRun.runs(runs);
       runnable.run();
    }
}
