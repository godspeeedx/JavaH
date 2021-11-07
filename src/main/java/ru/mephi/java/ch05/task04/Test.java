package ru.mephi.java.ch05.task04;

import java.util.ArrayList;

public class Test {
        public static void main(String[] args) {
            WithoutExc obj = new WithoutExc();
            ArrayList<Double> list = new ArrayList<>();
            ArrayList<Double> sum = null;
            if (obj.sumOfValues("src/main/resources/file", sum) == Error.OK){
                System.out.println("Sum = " + list.get(0));
            } else {
                System.out.println(obj.sumOfValues("src/main/resources/file", sum));
            }

            if (obj.sumOfValues("file", sum) == Error.OK){
                System.out.println("Sum = " + list.get(0));
            } else {
                System.out.println(obj.sumOfValues("test", sum));

            }
        }

}
