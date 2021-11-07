package ru.mephi.java.ch03.task14;

import ru.mephi.java.ch03.task02.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MyArraySort {
    public static void Sort(Employee[] employees){
        // Класс::метод
        Function<Employee,Double> getMeasure  = Employee::getMeasure;
        //Класс::static метод
        Function<Employee,String> getName = Employee::getNameStat;
        Employee employee = new Employee("Ivan", 10);
        Supplier<Double> supplier = employee::getMeasure;


        Arrays.sort(employees, Comparator.comparing(getMeasure).thenComparing(getName));
    }
    public static void SortRev(Employee[] employees){
        Arrays.sort(employees, Comparator.comparing(Employee::getMeasure).reversed().thenComparing(Employee::getName));
    }
}

