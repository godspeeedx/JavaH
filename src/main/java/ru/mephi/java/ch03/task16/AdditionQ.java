package ru.mephi.java.ch03.task16;

import ru.mephi.java.ch02.task18.BinaryHeap;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class AdditionQ {
    public static void main(String[] args) {
        // Объект::Метод Экземпляра
        Integer numb = 30;
        Comparator<Integer> l = Integer::compare;// Класс::статик метод
        Comparator<Integer> k = Integer::compareTo;// Класс::метод
        Comparator<Integer> z = l::compare;// Объект::метод
        UnaryOperator<Integer> ds = numb::compareTo;
         ds.apply(10);
       l.compare(10, 15);
       Integer firstNumb = 10;
       Integer secondNumb = 15;;
       Integer.compare(firstNumb, secondNumb);
       firstNumb.compareTo(10);
       l.compare(firstNumb, secondNumb);
      // Comparator.comparingInt()


    }
}
