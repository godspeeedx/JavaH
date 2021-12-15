package ru.mephi.java.ch06.extraTask.instOfArr;

import ru.mephi.java.ch06.extraTask.contrvar.Manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MyClass extends ArrayList<String>{
    public MyClass() {
        super();
    }

    @Override
    public String get(int index) {
        return super.get(index);
    }

    @Override
    public boolean add(String s) {
        return super.add(s);
    }

    // Arraylist<String> st , Object obj = st - в другом методе, потом прикастить к Arraylist<String> но безопасно, могу передавать инфу
    public ArrayList<String> getArray(){
        return this;
    }

}
