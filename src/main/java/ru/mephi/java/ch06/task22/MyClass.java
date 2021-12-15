package ru.mephi.java.ch06.task22;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class MyClass {
    public static void main(String[] args) {
        try {
            doWork(MyClass::obekt, new Exception("lalalla"));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.out.println("--------------------------------------------------------------");
        try {
             doWork(MyClass::obekt, (Supplier<Exception>) Exception::new);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static int obekt() throws Exception {
        throw new Exception("Suiiii");

    }

    public static <V, T extends Exception> V doWork(Callable<V> c, T ex) throws T {
        try {
            return c.call();
        } catch (Exception realEx) {
            ex.initCause(realEx);
            throw ex;
        }
    }

    // сделать для class T
    public static <V, T extends Exception> V doWork(Callable<V> c, Class<T> ex) throws Exception {
        try {
            return c.call();
        } catch (Exception realEx) {
            realEx.initCause(ex.getDeclaredConstructor().newInstance());
            throw realEx;
        }
    }

    // Supplier лучше чем exception так как можно создавать свой Exception при необходимости, зачем нужен этот метод
    // Когда мы передаём ошибку она ни к чему не привязана, а тут мы создаём её
    // В зависимости от того, что мы вызываем мы хотим видеть разные ошибки (для кого-то или чего-то)
    //
    public static <V, T extends Exception> V doWork(Callable<V> c, Supplier<T> ex) throws T {
        try {
            return c.call();
        } catch (Exception realEx) {
            T e = ex.get();
            e.initCause(realEx);
            throw e;
        }
    }
}
