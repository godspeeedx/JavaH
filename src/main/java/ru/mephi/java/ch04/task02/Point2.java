package ru.mephi.java.ch04.task02;

import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

public class Point2 {
    private final double x;
    private final double y;

    public Point2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    private void toR(){
        System.out.println("lalalal");
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[x=" + x + ", y=" + y + "]";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Point2 other = (Point2) otherObject;
        Double x1 = x;
        Double x2 = other.getX();
        Double y1 = y;
        Double y2 = other.getY();
        return x1.equals(x2) && y1.equals(y2);
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }
}
