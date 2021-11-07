package ru.mephi.java.ch03.task14;

import ru.mephi.java.ch03.task02.Employee;
import ru.mephi.java.ch03.task02.Measurable;

public class Test14 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];
        employees[0] = new Employee("Asha", 10);
        employees[1] = new Employee("Ira", 6);
        employees[2] = new Employee("LIra", 6);
        employees[3] = new Employee("Ira", 9.2);
        MyArraySort.Sort(employees);
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getName() + " Salary = " + employees[i].getMeasure());
        }
        System.out.println("After reverse");
        MyArraySort.SortRev(employees);
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getName() + " Salary = " + employees[i].getMeasure());
        }
    }
}
