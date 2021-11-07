package ru.mephi.java.ch04.ForTest;

import ru.mephi.java.ch04.addTask.SerializeRef;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassHelper {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
       AddPoint addPoint = new AddPoint(3,6);
        Method[] methods = addPoint.getClass().getMethods();
       Object obj = addPoint.getClass().getDeclaredConstructor().newInstance();

        SerializeRef.setOneFilled(addPoint, "x","3.4");
        System.out.println(addPoint.getX());

    }

    
}
