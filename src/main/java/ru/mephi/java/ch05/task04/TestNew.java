package ru.mephi.java.ch05.task04;

import ru.mephi.java.ch05.extraTask.FileFormatException;
import ru.mephi.java.ch05.task02.Sum;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestNew {
    public static void main(String[] args) {
        String f1 = "src/main/resources/f1";
        String f2 = "src/main/resources/f2";
        String f3 = "src/main/resources/f3";
        String f4 = "src/main/resources/f4";
        try {
            System.out.println(myMethodWithExc(f1, f2, f3, f4));
        } catch (FileNotFoundException | FileFormatException e) {
            e.printStackTrace();
        }
        ArrayList<Double> res = new ArrayList<>();
        Error er = myMethodWithErr(f1, f2, f3, f4, res);
        if (er == Error.OK) {
            System.out.println(res);
        } else System.out.println(er);
    }

    public static Double myMethodWithExc(String file1, String file2, String file3, String file4) throws FileNotFoundException, FileFormatException {
        Sum sum = new Sum();
        Double one = sum.sumOfValues(file1);
        Double two = sum.sumOfValues(file2);
        Double three = sum.sumOfValues(file3);
        Double four = sum.sumOfValues(file4);
        return (2 * one) / (4 * two) + (three - four) * 2;
    }

    public static Error myMethodWithErr(String file1, String file2, String file3, String file4, ArrayList<Double> result) {
        WithoutExc w = new WithoutExc();
        ArrayList<Double> one = new ArrayList<>();
        ArrayList<Double> two = new ArrayList<>();
        ArrayList<Double> three = new ArrayList<>();
        ArrayList<Double> four = new ArrayList<>();
        if (w.sumOfValues(file1, one) == Error.OK) {
            if (w.sumOfValues(file2, two) == Error.OK) {
                if (w.sumOfValues(file3, three) == Error.OK) {
                    if (w.sumOfValues(file4, four) == Error.OK) {
                        result.add((2 * one.get(1)) / (4 * two.get(1)) + (three.get(1) - four.get(1)) * 2);
                        return Error.OK;
                    }
                    return w.sumOfValues(file4, four);
                }
                return w.sumOfValues(file3, three);
            }
            return w.sumOfValues(file2, two);
        }
        return w.sumOfValues(file1, one);
    }
}
