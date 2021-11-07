package ru.mephi.java.ch03.task08;

public class Test08 {
    public static void main(String[] args) {
        Greeter gr1 = new Greeter(10, "Sasha");
        Greeter gr2 = new Greeter(10, "Russia");
        new Thread(gr2).start();
        new Thread(gr1).start(); // отложенный вызов тут, так как потоку передаётся
        Integer.compare(5,8);
        Double.compare(1.0,3.0);
    }
}
