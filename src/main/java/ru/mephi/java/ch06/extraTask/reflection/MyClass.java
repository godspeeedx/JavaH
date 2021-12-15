package ru.mephi.java.ch06.extraTask.reflection;

import ru.mephi.java.ch06.task03.Table;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;

public class MyClass {
    public static void main(String[] args) {
        demo(NewEntry.class);
    }

    public static <T> T run(ArrayList<? extends T> t){
        return null;
    }
    private static void demo(Class<?> cl) {
        TypeVariable<?>[] vars = cl.getTypeParameters();
        Type[] bounds = vars[0].getBounds();
        if (bounds[1] instanceof ParameterizedType) {
            ParameterizedType p = (ParameterizedType) bounds[1];
            Type[] typeArguments = p.getActualTypeArguments();
            if (typeArguments[0] instanceof WildcardType) {
                WildcardType t = (WildcardType) typeArguments[0];
                Type[] upper = t.getUpperBounds();
                Type[] lower = t.getLowerBounds();
                if (upper.length > 0) {
                    String description = upper[0].getTypeName();
                    System.out.println(description);
                }
            }
        }
    }



}
