package ru.mephi.java.ch03.task01;

public class Employee implements Measurable {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    public static double average(Measurable[] objects) {
        double sal = 0;
        for (int i = 0; i < objects.length; i++) {
            sal += objects[i].getMeasure();
        }
        sal = sal/objects.length;
        return sal;
    }

}
