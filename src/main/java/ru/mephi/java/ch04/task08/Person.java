package ru.mephi.java.ch04.task08;

public class Person<T> {
    private T struct;
    private String name;

    public Person(T struct, String name) {
        this.struct = struct;
        this.name = name;
    }

    public T getStruct() {
        return struct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
