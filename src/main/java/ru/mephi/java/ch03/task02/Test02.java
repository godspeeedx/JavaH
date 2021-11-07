package ru.mephi.java.ch03.task02;


public class Test02 {
    public static void main(String[] args) {
        Measurable[] objects = new Employee[4];
        objects[0] = new Employee("Sasha", 10);
        objects[1] = new Employee("Ira", 6);
        objects[2] = new Employee("Ira", 8.8);
        objects[3] = new Employee("Ira", 9.2);
        System.out.println(Employee.getNameMaxSalary(objects));
    }
}
