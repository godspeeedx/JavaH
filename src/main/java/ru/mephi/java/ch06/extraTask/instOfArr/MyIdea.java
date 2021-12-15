package ru.mephi.java.ch06.extraTask.instOfArr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class MyIdea {
    private static ArrayList<String> myPersons = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> myStaff = new ArrayList<>();
        myStaff.add("Ura");
        myStaff.add("Dima");
        myStaff.add("Lera");
        myStaff.add("Any");
        myPersons.get(1);
        String[] str = new String[3];
        str[0] = "Glasha";
        str[1] = "Tasha";
        str[2] = "Pasha";
        addPerson(myStaff, String.class);
        addPerson(str, String.class);
        myPersons.forEach(System.out::println);

    }

    public static void addPerson(Object obj, Class<?> className) {
        Objects.requireNonNull(obj);
        if (String.class.isAssignableFrom(className)) {
            if(obj.getClass().isArray()) {
                String[] str = (String[]) obj;
                myPersons.addAll(Arrays.asList(str));
            }
            else if (obj instanceof ArrayList) {
                ArrayList<String> ar = (ArrayList<String>) obj;
                myPersons.addAll(ar);
            }
        }
    }
}

