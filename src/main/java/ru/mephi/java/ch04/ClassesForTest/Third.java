package ru.mephi.java.ch04.ClassesForTest;

import java.util.Arrays;

public class Third {
    int[][] mass;
    String string;

    public Third() {
        mass = null;
        string = "";
    }

    public Third(int[][] mass, String string) {
        this.mass = mass;
        this.string = string;
    }

    @Override
    public String toString() {
        return "Third{" +
                "mass=" + Arrays.toString(mass) +
                ", string='" + string + '\'' +
                '}';
    }

    public void setString(String string) {
        this.string = string;
    }

}
