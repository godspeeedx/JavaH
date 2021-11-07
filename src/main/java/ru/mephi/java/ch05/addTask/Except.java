package ru.mephi.java.ch05.addTask;

import java.util.ArrayList;

public class Except {
    public static void main(String[] args) {
        ArrayList<String> arrayList =new ArrayList<String>();
        arrayList.add("Выход за границы");
        arrayList.add("NullPointerException");
        arrayList.add("Деление на 0");
        Integer[] integers =  {2, 4,2} ;
        Integer[] d=  {2, 4} ;
        check(integers);
        check(null);
        check(d);

    }

    // функция меняющая 3-й элемент с 1-м, а второй это деление второго на разность 3 и первого
    public static void check(Integer[] integers){
        try {
            int buff = integers[0];
            integers[0] = integers[2];
            integers[2] = buff;
            integers[1] = integers[1]/(integers[2] - integers[0]);
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
