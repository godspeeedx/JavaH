package ru.mephi.java.ch03.task05;

public class ConstantSequence implements IntSequence{
    private final int constant;

    public ConstantSequence() {
        constant = 1;
    }

    public ConstantSequence(int constant) {
        this.constant = constant;
    }


    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public int next() {
        return constant;
    }

}
