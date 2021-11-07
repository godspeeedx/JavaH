package ru.mephi.java.ch03.task12;

//import com.sun.org.apache.xpath.internal.functions.Function;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FileSort {
    public static void sort (File[] files){

        Arrays.sort(files, Comparator.comparing(File::isFile).thenComparing(File::getPath));
    }
}
