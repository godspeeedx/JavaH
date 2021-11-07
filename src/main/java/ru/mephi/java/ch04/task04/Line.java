package ru.mephi.java.ch04.task04;

import ru.mephi.java.ch04.task02.Point2;

public class Line extends Shape {
    private Point2 to;

    public Line(Point2 from, Point2 to) {
        super(from);
        this.to = new Point2(to.getX(), to.getY());
    }

    @Override
    public Point2 getCenter() {
        return new Point2((this.point.getX() + this.to.getX()) / 2,
                (this.point.getY() + this.to.getY()) / 2);
    }

    @Override
    public Line clone() {
        return new Line(this.point, this.to);
    }

    @Override
    public String toString() {
        return "Line{" + "from=" + point +
                "to=" + to +
                '}';
    }
}
