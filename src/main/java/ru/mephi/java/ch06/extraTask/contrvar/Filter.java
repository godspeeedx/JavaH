package ru.mephi.java.ch06.extraTask.contrvar;

import ru.mephi.java.ch03.task01.Employee;

import java.util.Objects;
import java.util.function.Predicate;

public class Filter {

    public static void main(String[] args) {
        Employee[] emp = {new Employee("Mike",10), new Manager("Sasha", 20,10)};
        Predicate<Employee> ep = employee -> employee.getMeasure() > 25;
        Predicate<Objects> op = o -> o.toString().length() > 10;
        printAll(emp, ep);
    }
    public static void printAll(Employee[] staff, Predicate<?super Employee> filter){
        for(Employee e: staff){
            if(filter.test(e)){
                System.out.println(e.getName());
            }
        }
    }
}
