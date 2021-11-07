package ru.mephi.java.ch05.task02;

import ru.mephi.java.ch05.extraTask.FileFormatException;

import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        Sum sum = new Sum();
        try {
            System.out.println(sum.sumOfValues("src/main/resources/file"));
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (FileFormatException e) {
            e.printStackTrace();
        }
    }
}
