package ru.mephi.java.ch05.task10;

public class Factorial {

    public static void main(String[] args) {
        try {
            System.out.println(factorial(4));
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    public static int factorial(int n) throws IllegalArgumentException {
        if (n == 1 | n == 0) {
            Exception ex = new Exception("fsaffa");
            ex.printStackTrace(System.out);
            return 1;
        }
        return n * factorial(n - 1);
    }
}
