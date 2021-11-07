package ru.mephi.java.ch02.task06;

public class Tester206 {
    /**
     * Here's start point of the program
     * @param args comand lines value
     */
    public static void main(String[] args) {
        PointMutator point = new PointMutator(3,4);
        point.translate(1,3);
        point.scale(0.5);
        System.out.println(point.getX());
        System.out.println(point.getY());
    }
}
