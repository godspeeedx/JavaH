package ru.mephi.java.ch04.ClassesForTest;

import java.util.Objects;

public class First {
    public int length;
    public String name;

    public First(){
        length = 0;
        name = "";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof First)) return false;
        First first = (First) o;
        return getLength() == first.getLength() && Objects.equals(getName(), first.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLength(), getName());
    }

    @Override
    public String toString() {
        return "First{" +
                "length=" + length +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public First(int length, String  name) {
        this.name = name;
        this.length = length;
    }

}
