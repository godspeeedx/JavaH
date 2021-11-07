package ru.mephi.java.ch03.task10;

import java.io.File;
import java.io.FileFilter;

public class MyFiles {
    public static File[] getSubdirectories(String p) {
        File check = new File(p);
        File[] dir = check.listFiles(File::isDirectory);
        if (dir == null) {
            return new File[0];
        }
        return dir;
    }

    public static File[] getSubdirectoriesForInner(String p) {
        File check = new File(p);
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        };
        File[] dir = check.listFiles(fileFilter);

        if (dir == null) {
            return new File[0];
        }
        return dir;
    }

    public static File[] getSubdirectoriesForLambda(String p){
        File check = new File(p);
        File[] dir = check.listFiles(file-> file.isDirectory());
        if (dir == null) {
            return new File[0];
        }
        return dir;
    }

}
