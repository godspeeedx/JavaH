package ru.mephi.java.ch05.task04;
// сделать 3 и 4 по одинаковому и пойму почему искл помогает писать меньше кода
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WithoutExc {

    public Error readValues(String filename, ArrayList<Double> list){
        File file = new File(filename);
        if (!file.exists()) {
            return Error.FILE_NOT_FOUND;
        }
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] str = sc.nextLine().split(",");
                for (String s : str) {
                    try {
                        s = s.replaceAll("\\s", "");
                        list.add(Double.parseDouble(s));
                    } catch (NumberFormatException e) {
                       return Error.INCORRECT_FORMAT;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            return Error.FILE_NOT_FOUND;
        }

        return Error.OK;
    }

    public Error sumOfValues(String filename, ArrayList<Double> doub)  {
        ArrayList<Double> list = new ArrayList<>();
        Error code = readValues(filename, list);
        if (code == Error.OK){
            Double sum = 0.0;
            for (double numb : list){
                sum += numb;
            }
            doub.add(sum);
        }
        return code;
    }
}
