package ru.mephi.java.ch06.extraTask.contrvar;

import ru.mephi.java.ch03.task01.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;


public class Comporator<T> {

    public static void main(String[] args) {
        Employee[] emp = {new Employee("Mike", 10), new Manager("Sasha", 20, 10),
                new Employee("Like", 40), new Manager("Tasha", 30, 60)};
        Comparator<Employee> c1 = (e1, e2) -> (int) (e1.getMeasure() - e2.getMeasure());
        Comparator<Object> c2 = (e1, e2) -> (int) (e1.hashCode() - e2.hashCode());
        sort(emp, c1);
        System.out.println(Arrays.toString(emp));
        sort(emp, c2);
        System.out.println(Arrays.toString(emp));

    }

    public static <T> void sort(T[] mass, Comparator<? super T> comparator) {
        for (int i = 0; i < mass.length - 1; i++) {
            for (int j = i + 1; j < mass.length; j++) {
                if (comparator.compare(mass[i], mass[j]) > 0) {
                    T buf = mass[i];
                    mass[i] = mass[j];
                    mass[j] = buf;
                }
            }
        }
    }
}
