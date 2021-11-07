package ru.mephi.java.ch05.task02;

import ru.mephi.java.ch05.extraTask.FileFormatException;
import ru.mephi.java.ch05.task01.Value;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Sum {


    public double sumOfValues(String fileName) throws FileNotFoundException, FileFormatException {
        Value value = new Value();
        ArrayList<Double> ar = value.readValues(fileName); // 1 000 000,
        double sum = 0; //
        for (double d: ar) {
            sum += d;
        }
        return sum;
    }
}
