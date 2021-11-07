package ru.mephi.java.ch03.task10;


import java.io.File;

public class Test10 {
    public static void main(String[] args) {
        String path = "/Users/sasha/Desktop/6 сем";
        File[] str = MyFiles.getSubdirectoriesForInner(path);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i].getName());
        }



    }
}
