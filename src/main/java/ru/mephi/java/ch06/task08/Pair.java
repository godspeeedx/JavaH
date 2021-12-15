package ru.mephi.java.ch06.task08;

public class Pair<E extends Comparable<E>> {
    private E first;
    private E second;
    public Pair(E first, E second){
        this.first = first;
        this.second = second;
    }
    public E min(){
        int x = first.compareTo(second);
        if(x > 0) {
            return second;
        } else if (x < 0) {
            return first;
        }
        return first;
    }

    public E max(){
        int x = first.compareTo(second);
        if(x > 0) {
            return first;
        } else if (x < 0) {
            return second;
        }
        return first;
    }

    public E getSecond() {
        return second;
    }

    public void setSecond(E second) {
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }
}
