package ru.mephi.java.ch04.task03;

public class LabeledPoint3 extends Point3 {
    private final String label;
    public LabeledPoint3(double x, double y, String label) {
        super(x, y);
        this.label = label;
    }
    public void something(){
        System.out.println(x +  " " + y + " " +  label);
    }

    public String getLabel() {
        return label;
    }
}
