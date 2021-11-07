package ru.mephi.java.ch04.task05;

import ru.mephi.java.ch04.task02.Point2;
import ru.mephi.java.ch04.task04.Circle;
import ru.mephi.java.ch04.task04.Line;
import ru.mephi.java.ch04.task04.Rectangle;

public class Tester05 {
    public static void main(String[] args) {
        Circle circle = new Circle(new Point2(1.3, -2.8),3 );
        Rectangle rectangle = new Rectangle(new Point2(2.5,3.0),4,2);
        Line line = new Line(new Point2(4,6), new Point2(3,6));
        System.out.println("Not clones");
        System.out.println(circle.toString());
        System.out.println(rectangle.toString());
        System.out.println(line.toString());
        Line cloneLine = line.clone();
        Circle cloneCircle = circle.clone();
        Rectangle cloneRectangle = rectangle.clone();
        System.out.println("Clones");
        System.out.println(cloneCircle.toString());
        System.out.println(cloneRectangle.toString());
        System.out.println(cloneLine.toString());


    }
}
