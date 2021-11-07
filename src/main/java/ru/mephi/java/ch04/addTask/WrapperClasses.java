package ru.mephi.java.ch04.addTask;

import java.util.ArrayList;

public class WrapperClasses {
    private static String[] wrappers = {"java.lang.Boolean",
            "java.lang.Integer", "java.lang.Double", "java.lang.Character"};



    public static Object checkWrappers(String str) {
        int x = -1;
        for (int i = 0; i < wrappers.length; i++) {
            if (wrappers[i].equals(str)) {
                x = i;
                break;
            }
        }
        switch (x) {
            case 0:
                return Boolean.TRUE;
            case 1:
                return new Integer(0);


        }
        return null;

    }


}
