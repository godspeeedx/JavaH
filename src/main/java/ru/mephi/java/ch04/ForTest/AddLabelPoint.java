package ru.mephi.java.ch04.ForTest;

public class AddLabelPoint extends AddPoint {


    private String label;

    public AddLabelPoint(double x, double y) {
        super(x, y);
    }

    public String getLabel() {
        return label;
    }

    public static void per(String str) {
        System.out.println("-----------------------------"+str+"-----------------------------");
        System.err.close();
        System.setErr(System.out);

    }
}
