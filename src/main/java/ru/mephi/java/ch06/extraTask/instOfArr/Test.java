package ru.mephi.java.ch06.extraTask.instOfArr;

import ru.mephi.java.ch06.extraTask.instOfArr.MyClass;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        MyClass me = new MyClass();
        me.add("lalalla");
        System.out.println(me.get(0));
        ArrayList<String> str = me.getArray();
        System.out.println(str.get(0));

    }
}
