package ru.mephi.java.ch05.task01;

import ru.mephi.java.ch05.extraTask.FileFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Value {
    public ArrayList<Double> readValues(String filename) throws FileNotFoundException, FileFormatException, NumberFormatException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        ArrayList<Double> doubles = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] str = scanner.nextLine().split(",");// one, two,
                for (String s : str) {
                    try {
                        s = s.replaceAll("\\s", "");
                        doubles.add(Double.parseDouble(s));
                    } catch (NumberFormatException e) { //
                        NumberFormatException n = new NumberFormatException("It's not double - " + e.getMessage());
                        n.initCause(e);// исправить
                        throw n;
                    }
                }
            }
        }
        return doubles;
    }
}
