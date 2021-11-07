package ru.mephi.java.ch04.task01;

public class Tester01 {
    public static void main(String[] args) {
        Point point = new Point(3.4, 2.9);
        LabeledPoint labeledPoint = new LabeledPoint(2.8, 8.9, "NewLabel");
        System.out.println(labeledPoint.getX());
        System.out.println(labeledPoint.getY());
        System.out.println(labeledPoint.getLabel());
        System.out.println(point.getX());
        System.out.println(point.getY());
    }
}
