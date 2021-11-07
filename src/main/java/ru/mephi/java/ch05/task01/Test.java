package ru.mephi.java.ch05.task01;

import ru.mephi.java.ch05.extraTask.FileFormatException;

import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        Value value = new Value();
        try {
            //value.readValues("file");
            System.out.println( value.readValues("src/main/resources/file"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (FileFormatException e) {
            e.printStackTrace();
        }
    }
}
