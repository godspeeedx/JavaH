package ru.mephi.java.ch06.extraTask.contrvar;

import ru.mephi.java.ch03.task01.Employee;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public double getMeasure() {
        return super.getMeasure() + bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + bonus + " salary= " +super.getMeasure()+
                "Name= "+super.getName()+
                '}';
    }
}
