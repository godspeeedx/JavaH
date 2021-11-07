package ru.mephi.java.ch04.task06;

public class Tester06 {
    public static void main(String[] args) {
        Item x = new Item("T-shirt", 10);
        DiscountedItem y = new DiscountedItem("T-shirt", 10, 3);
        DiscountedItem z = new DiscountedItem("T-shirt", 10, 2);
        System.out.println(" x == y : " + x.equals(y));
        System.out.println(" y == x : " + y.equals(x));
        System.out.println(" x == z : " + x.equals(z));
        System.out.println(" z == x : " + z.equals(x));
        System.out.println(" y == z : " + y.equals(z));
    }
}
