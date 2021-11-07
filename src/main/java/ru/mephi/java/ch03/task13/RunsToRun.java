package ru.mephi.java.ch03.task13;

public class RunsToRun {
    public static Runnable runs(Runnable[] runnables) {
        return () -> {
            for (Runnable r : runnables) {
                r.run();
            }
        };
    }
}
