package ru.mephi.java.ch05.addTask;

public class Chained {

    public static void main(String[] args) {
        try {
            System.out.println(divide(5, 0));
        } catch (RuntimeException ex) {
            System.err.println(ex.getCause());
            System.err.println(ex.getMessage());

        }
    }

    public static int divide(int x, int y) throws RuntimeException {
        int z;
        try {
            z = x / y;
        } catch (ArithmeticException ex) {
            throw new RuntimeException("Один из аргументов передан неверно", ex);
        }
        return z;
    }
}
