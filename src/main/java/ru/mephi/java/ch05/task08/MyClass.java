package ru.mephi.java.ch05.task08;

import java.util.concurrent.locks.ReentrantLock;

public class MyClass implements AutoCloseable {
    private ReentrantLock lock;

    private MyClass(ReentrantLock lock) {
        this.lock = lock;
    }

    public void lock() {
        lock.lock();
        System.out.println("lock");
    }

    public static MyClass getLock() {
        MyClass closableClass = new MyClass(new ReentrantLock());
        closableClass.lock();
        return closableClass;
    }

    @Override
    public void close() {
        try {
            lock.unlock();
            System.out.println("unlock");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
