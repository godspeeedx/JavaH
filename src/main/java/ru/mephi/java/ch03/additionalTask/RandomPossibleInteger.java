package ru.mephi.java.ch03.additionalTask;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class RandomPossibleInteger {
    public static void  checksmth(Integer x, Consumer consumer){
        System.out.println(x);
        consumer.accept(x);
    }

    static public void print(Integer x, InterForCheck interForCheck){


        Integer result = interForCheck.run(x);
        if(result == null){
            System.out.println("Увы не сегодня");
        } else {
            System.out.println("Ураааа: " + result);
        }
    }
}
