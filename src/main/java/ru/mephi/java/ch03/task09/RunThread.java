package ru.mephi.java.ch03.task09;

public class RunThread {
    public static void runTogether(Runnable... tasks){
        for (Runnable t: tasks){
            new Thread(t).start();
        }
    }
    public static void runInOrder(Runnable... tasks){
        for (Runnable t: tasks){
            t.run();
        }
    }
}
