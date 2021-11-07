package ru.mephi.java.ch02.task05;

/**
 * this is class of point on the plane, it's immutable
 *
 * @author Vertelnikov Aleks
 * @version 1.0.0
 */


public class Point {
    /**
     * x is x coordinate on the plane
     */
    private final double x;
    /**
     * y is y coordinate on the plane
     */
    private final double y;

   /* public static void main(String[] args) {
        Point p = new Point(3,4).translate(1,3).scale(0.5);
        System.out.println(p.getX());
        System.out.println(p.getY());

    } */

    /**
     * Constructor without arguments
     */
    public Point() {
        this(0,0);
    }

    public static Point coordinateX(double x){
        return new Point(x,0);
    }

    public static Point coordinateY(double y){
        return new Point(0,y);
    }
    /**
     * Constructor with 2 arguments
     *
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get x-coordinate
     *
     * @return x-coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * get y-coordinate
     *
     * @return y-coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * make new instance of the class with offset coordinates
     *
     * @param x x-axis offset
     * @param y y-axis offset
     * @return instance of the class with offset coordinates
     */
    public Point translate(double x, double y) {
        return new Point((this.x + x), (this.y + y));
    }

    /**
     * make new instance of the class after zoom factor
     *
     * @param changeScale zoom factor
     * @return instance of the class after zoom factor
     */
    public Point scale(double changeScale) {
        return new Point((this.x * changeScale), (this.y * changeScale));
    }

}
