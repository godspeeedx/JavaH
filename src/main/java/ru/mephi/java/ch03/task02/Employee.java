package ru.mephi.java.ch03.task02;

public class Employee implements Measurable{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public static String getNameStat (Employee employee){
        return employee.getName();
    }

    public String getName() {
        return name;
    }

    @Override
    public  double getMeasure() {
        return salary;
    }

    @Override
    public int largest(Measurable[] objects) {
        int index = -1;
        double maxSalary = 0;
        for (int i = 0; i < objects.length; i++) {
            if(objects[i] instanceof Employee){
                Employee employee = (Employee) objects[i];
                if(maxSalary < employee.salary){
                    index = i;
                    maxSalary = employee.salary;
                }
            }
        }


        return index;
    }

    public static String getNameMaxSalary(Measurable[] objects){
        if (objects.length == 0) {
            return null;
        }
        int i = objects[0].largest(objects);
        if (i!=-1){
            return ((Employee) objects[i]).getName();
        }
        return null;
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
