package ru.mephi.java.ch03.task05;

@FunctionalInterface
public interface IntSequence {
    default boolean hasNext() {
        return true;
    }

    static IntSequence constant1(int n) {
        return new ConstantSequence(n);
    }

    // добавить метод с лямбда выоажением
    static IntSequence constant2(int n) {
        return () -> n;
    }

    int next();
}
