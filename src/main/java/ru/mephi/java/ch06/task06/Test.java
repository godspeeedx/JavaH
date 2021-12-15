package ru.mephi.java.ch06.task06;


import ru.mephi.java.ch03.task01.Employee;
import ru.mephi.java.ch06.extraTask.contrvar.Manager;

import java.util.ArrayList;

// Добавить примеров
public class Test {
    public static void main(String[] args) {
        ArrayList<Manager> arr = new ArrayList<>();
        Manager manager1 = new Manager("Sasha", 10, 20);
        Manager manager2 = new Manager("Pasha", 20, 40);
        Manager manager3 = new Manager("Rasha", 30, 50);
        arr.add(manager1);
        arr.add(manager2);
        arr.add(manager3);
        ArrayList<Employee> emp = new ArrayList<>();
        Move.move2(emp, arr);
        System.out.println(emp.size());
        ArrayList<Object> obj = new ArrayList<>();
        Move.move2(obj, emp);
    }
}
