package ru.mephi.java.ch06.task10;

//import ru.mephi.java.ch06.extraTask.contrvar.Comporator;


import java.util.Comparator;
import java.util.Objects;

public class ArrayMy {
    // добавить метод с компоратором но чтобы код переиспользовался!
     public static <E> E min(Comparator<E> comparator, E[] array){
         Objects.requireNonNull(array);
         E buf = array[0];
         for (E b : array) {
             if (comparator.compare(b, buf) < 0) {
                 buf = b;
             }
         }
         return buf;
    }
    public static <E extends Comparable<? super E>> E min(E[] array) {
       return ArrayMy.min(Comparator.comparing(array[0]::compareTo) ,array);
       // сделать правильно - вроде так
    }


    public static <E extends Comparable<? super E>> E max(E[] array) {
        Objects.requireNonNull(array);
        E buf = array[0];
        for (E b : array) {
            if (b.compareTo(buf) > 0) {
                buf = b;
            }
        }
        return buf;
    }
}
