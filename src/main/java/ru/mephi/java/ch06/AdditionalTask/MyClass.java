package ru.mephi.java.ch06.AdditionalTask;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.Scanner;
import org.reflections.scanners.SubTypesScanner;
import ru.mephi.java.ch06.extraTask.contrvar.Manager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyClass {
    public static void main(String[] args) throws ClassNotFoundException {
     //   Class<?> classOfArray = Class.forName("java.lang.Number");
     //   ArrayList<Class<?>> myList = new ArrayList<>((new Reflections()).getSubTypesOf(classOfArray));
      //  for (int i = 0; i < myList.size(); i++) {
      //      myList.set(i, (Array.newInstance(myList.get(i), 0)).getClass());
       // }
       // System.out.println(myList.toString());
      //  System.out.println(Object.class.getPackageName());
      // System.out.println(getReflectionsSubTypes());
       // System.out.println( new Reflections(Manager.class).getSubTypesOf(Manager.class));
        System.out.println(Class.forName("ru.mephi.java.ch06.task08.Pair").toGenericString());
        List<Class<?>> classes = ClassFinder.find("ru.mephi.java.ch06.AdditionalTask");
        for (Class<?> cl:
             classes) {
          // cl.isAssignableFrom();
            System.out.println(cl.getName());
        }
    }

    public static Set<Class<? extends IncompatibleClassChangeError>> getReflectionsSubTypes() {
        Reflections reflections = new Reflections(IncompatibleClassChangeError.class.getPackageName());
       return reflections.getSubTypesOf(IncompatibleClassChangeError.class);
    }
}
