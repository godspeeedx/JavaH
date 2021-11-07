package ru.mephi.java.ch04.task04;

import ru.mephi.java.ch04.task02.Point2;

public abstract class Shape {
    protected Point2 point;

    public Shape(Point2 point) {
        this.point = new Point2(point.getX(), point.getY());
    }

    public void moveBy(double dx, double dy) {
        point = new Point2(point.getX() + dx, point.getY() + dy );
    }

    public abstract Point2 getCenter();
}
