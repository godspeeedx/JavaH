package ru.mephi.java.ch04.task02;

public class Tester02 {
    public static void main(String[] args) {
        Point2 point = new Point2(1.8, 1.9);
        Point2 point2 = new Point2(1.97, 1.93);
        Point2 point3 = new Point2(1.8, 1.9);
        Point2 point4 = new Point2(1.84, 1.9);
        Point2 point5 = new Point2(1.9, 1.8);
        System.out.println(point.equals(point3));
        System.out.println(point.equals(point2));
        System.out.println(point.equals(point4));
        System.out.println("point hash =  "+point.hashCode());
        System.out.println("point 2 hash = " + point2.hashCode());
        System.out.println("point 5 hash = " + point5.hashCode());
        System.out.println(point.toString());
        LabelPoint2 labelPoint = new LabelPoint2(1.8, 1.9, "lala");
        LabelPoint2 labelPoint2 = new LabelPoint2(1.8, 1.9, "lala");
        LabelPoint2 labelPoint3 = new LabelPoint2(1.8, 1.9, "lalaS");
        System.out.println(labelPoint2.equals(labelPoint));
        System.out.println(labelPoint2.equals(labelPoint3));
        System.out.println("labelPoint hash = " + labelPoint.hashCode());
        System.out.println("labelPoint3 hash = " + labelPoint3.hashCode());
        System.out.println(labelPoint3.toString());
    }
}
