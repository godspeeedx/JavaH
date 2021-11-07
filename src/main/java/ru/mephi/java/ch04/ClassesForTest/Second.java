package ru.mephi.java.ch04.ClassesForTest;

import java.util.Objects;

public class Second {
    First first;
    String secondName;

    @Override
    public String toString() {
        return "Second{" +
                "first=" + first.toString() +
                ", secondName='" + secondName + '\'' +
                '}';
    }


    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public Second(){
        this.first = null;
        secondName = "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Second)) return false;
        Second second = (Second) o;
        return Objects.equals(getFirst(), second.getFirst()) && Objects.equals(secondName, second.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), secondName);
    }

    public void setFirst(First first) {
        this.first = first;
    }

    public Second(First first, String secondName) {
        this.first = first;
        this.secondName = secondName;
    }

    public First getFirst() {
        return first;
    }



   // public void setFirst(Object first){
   //     if (first instanceof First){
   //         this.first = (First) first;
   //     }
   // }
}
