package ru.mephi.java.ch02.task05;

public class Tester205 {
    /**
     * Here start point of the program
     * @param args command line values
     */
    public static void main(String[] args) {
        Point p = new Point(3,4).translate(1,3).scale(0.5);
        System.out.println(p.getX());
        System.out.println(p.getY());

    }
}
