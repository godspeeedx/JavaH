package ru.mephi.java.ch05.task08;

import java.util.concurrent.locks.ReentrantLock;

public class Test {


    public static void main(String[] args) {
        try (MyClass lock = MyClass.getLock()) {
            System.out.println("Locked successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
