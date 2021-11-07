package ru.mephi.java.ch05.addTask;

public class Person {
    private String name;
    private double balance;

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Person(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

}
