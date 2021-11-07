package ru.mephi.java.ch02.task06;

/**
 * this is class of point on the plane, it's mutable
 * @version 1.0.0
 * @author Vertelnikov Aleks
 */

public class PointMutator {
    /**
     * x is x coordinate on the plane
     */
    private double x;
    /**
     * y is y coordinate on the plane
     */
    private double y;


    /**
     * Constructor without arguments
     */
    public PointMutator() {
        this.x = 0;
        this.y = 0;
    }

    /**
     *Constructor with 2 arguments
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public PointMutator(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *get x-coordinate
     * @return x-coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     *get y-coordinate
     * @return y-coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * the method offset coordinates
     * @param x x-axis offset
     * @param y y-axis offset
     */
    public void translate(double x, double y) {
        this.x += x;
        this.y += y;
    }

    /**
     * the method change coordinate using a zoom factor
     * @param changeScale zoom factor
     */
    public void scale(double changeScale) {
        this.x = this.x * changeScale;
        this.y = this.y * changeScale;
    }
}
