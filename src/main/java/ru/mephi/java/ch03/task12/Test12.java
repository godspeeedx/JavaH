package ru.mephi.java.ch03.task12;

import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;

public class Test12 {
    public static void main(String[] args) {
        String path = "/Users/sasha/Desktop/6 сем/ОТИК";
        File file = new File(path);
        File[] files = file.listFiles();
        FileSort.sort(files);
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i]);
            }
        }

    }
}
