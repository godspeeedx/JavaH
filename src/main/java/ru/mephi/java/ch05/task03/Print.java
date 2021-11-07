package ru.mephi.java.ch05.task03;

import ru.mephi.java.ch05.extraTask.FileFormatException;
import ru.mephi.java.ch05.task02.Sum;

import java.io.FileNotFoundException;

public class Print {
    public static void main(String[] args) {
        print("src/main/resources/file");
        print("file");
    }

    public static void print(String filename){
        try {
            Sum sum = new Sum();
            System.out.println(sum.sumOfValues(filename));
        } catch (FileNotFoundException ex){
            System.err.println("File "+filename+" isn't exist");
        } catch (FileFormatException e) {
            e.printStackTrace();
        }

    }
}
