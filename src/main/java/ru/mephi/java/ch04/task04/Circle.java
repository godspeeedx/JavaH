package ru.mephi.java.ch04.task04;

import ru.mephi.java.ch04.task02.Point2;

public class Circle extends Shape {
    private double radius;

    public Circle(Point2 center, double radius) {
        super(center);
        this.radius = Math.abs(radius);
    }

    @Override
    public Point2 getCenter() {
        return new Point2(this.point.getX(), this.point.getY());
    }

    @Override
    public Circle clone() {
        return new Circle(this.point, radius);
    }

    @Override
    public String toString() {
        return "Circle{" + "center=" + this.point.toString() +
                "radius=" + radius +
                '}';
    }
}
