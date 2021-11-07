package ru.mephi.java.ch01.task16;


public class Update {
    public static void main(String[] args) {
        System.out.println(average(3.4, 4.2, 3));
    }

    public static double average(double first_value, double... values) {
        double sum = first_value;
        for (double v : values) sum += v;
        return values.length == 0 ? 0 : sum / (values.length + 1);
    }
}
