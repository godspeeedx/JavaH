package ru.mephi.java.ch06.task12;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MinMax {
    public static void main(String[] args) {

    }

    public static <T> void minmax(List<T> elements, Comparator<? super T> comp,
                                  List<? super T> result) {
        Objects.requireNonNull(elements);
        T min = elements.get(0);
        T max = elements.get(0);
        for (T b: elements) {
            if(comp.compare(min, b) < 0){
                min = b;
            } else if(comp.compare(b, max) > 0){
                max = b;
            }
        }
        result.add(min);
        result.add(max);
    }
}
