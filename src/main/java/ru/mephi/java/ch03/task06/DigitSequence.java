package ru.mephi.java.ch03.task06;

import java.util.Iterator;

public class DigitSequence implements Iterator {
    private int number = 0;

    public DigitSequence(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean hasNext() {
        return number != 0;
    }

    @Override
    public Integer next() {
        int result = number % 10;
        number /= 10;
        return result;
    }

    public void remove() {
    }
}

