package ru.mephi.java.ch05.task04;

public class MyDouble {
    double value;

    public MyDouble(double v) {
        value = v;
    }
    public MyDouble(){

    }
    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
