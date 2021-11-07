package ru.mephi.java.ch04.ForTest;

public class AddPoint {
    protected  double x;
    protected  double y;

    public AddPoint(){
        this.x = 0;
        this.y = 0;
    }

    public AddPoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        System.out.println( Math.random());
    }

    public void setX(double x){
         this.x = x;
    }

    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }
}

