package ru.mephi.java.ch04.task04;

import ru.mephi.java.ch04.task02.Point2;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(Point2 topLeft, double width, double height) {
        super(topLeft);
        this.width = Math.abs(width);
        this.height = Math.abs(height);
    }

    @Override
    public Point2 getCenter() {
        return new Point2(point.getX() + width / 2, point.getY() - height / 2);
    }

    @Override
    public Rectangle clone() {
        return new Rectangle(this.point, this.width, this.height);
    }

    @Override
    public String toString() {
        return "Rectangle{" + "LeftTop=" + point.toString() +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
