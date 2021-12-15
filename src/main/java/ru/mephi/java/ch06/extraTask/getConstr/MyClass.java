package ru.mephi.java.ch06.extraTask.getConstr;

import ru.mephi.java.ch03.task01.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class MyClass {
    public static <T> T getConstr(Class<T> cl) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return cl.getDeclaredConstructor().newInstance();
    }


    public static void main(String[] args) {
        try {
            String st = getConstr(String.class);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        // сделать без рефлексии и с помощью интфанкшн
        Employee emp = MyClass.constP(Employee::new, 100);
        System.out.println(emp.getMeasure());

    }
    public static <P> P constP(IntFunction<P> constr, int x) {
        return constr.apply(x);
    }

    public static <P> P constP(Supplier<P> constr) {
        return constr.get();
    }


}
