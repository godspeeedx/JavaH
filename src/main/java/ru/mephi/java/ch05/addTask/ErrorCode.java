package ru.mephi.java.ch05.addTask;

import java.util.ArrayList;

public class ErrorCode {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Выход за границы");
        arrayList.add("NullPointerException");
        arrayList.add("Деление на 0");
        Integer[] integers = {2, 4, 2};
        Integer[] d = {2, 4};
        System.out.println(arrayList.get(check(d)));
        System.out.println(arrayList.get(check(null)));
        System.out.println(arrayList.get(check(integers)));

    }

    // функция меняющая 3-й элемент с 1-м, а второй это деление второго на разность 3 и первого
    //

    public static int check(Integer[] integers) {
        if (integers == null) {
            return 1;
        }
        if (integers.length < 3) {
            return 0;
        }
        int buff = integers[0];
        integers[0] = integers[2];
        integers[2] = buff;
        if (integers[2] - integers[0] == 0) {
            return 2;
        }
        integers[1] = integers[1] / (integers[2] - integers[0]);
        return -1;
    }
}
