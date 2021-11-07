package ru.mephi.java.ch03.task11;

import java.io.File;

public class MyList {
    public static String[] getFilesWithName(String path,String end){
        File check = new File(path);
        return check.list((dir, name) -> name.endsWith(end));
    }
}
