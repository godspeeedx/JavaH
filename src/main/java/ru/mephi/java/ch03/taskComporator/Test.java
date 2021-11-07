package ru.mephi.java.ch03.taskComporator;

import ru.mephi.java.ch03.task02.Employee;
import ru.mephi.java.ch03.task14.MyArraySort;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add( new Employee("Asha", 10));
        employees.add( new Employee("Ira", 6));
        employees.add( new Employee("LIra", 6));
        employees.add(new Employee("Ira", 9.2));


    }
}
