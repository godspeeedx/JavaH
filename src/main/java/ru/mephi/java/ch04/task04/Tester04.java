package ru.mephi.java.ch04.task04;

import ru.mephi.java.ch04.task02.Point2;

public class Tester04 {
    public static void main(String[] args) {
        Circle circle = new Circle(new Point2(1.3, -2.8),3 );
        Rectangle rectangle = new Rectangle(new Point2(2.5,3.0),4,2);
        Line line = new Line(new Point2(4,6), new Point2(3,6));
        System.out.println(circle.getCenter().toString());
        System.out.println(rectangle.getCenter().toString());
        System.out.println(line.getCenter().toString());
        Shape shape = circle;
        System.out.println(shape.getCenter().toString());
    }
}
