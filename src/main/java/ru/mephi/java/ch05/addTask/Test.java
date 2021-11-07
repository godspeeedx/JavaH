package ru.mephi.java.ch05.addTask;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Test {
    public static void main(String[] args) {
      //  Bank bank = new Bank();
       // bank.setPersons();
        //bank.offerDepositExc(12000);
       // bank.offerDepositErrCode(12000);
        String str = "200";
        System.out.println(Integer.parseInt(str));
        File file = new File("src/main/resources/task5.txt");
        try {
            file.createNewFile();
            try(PrintWriter pw = new PrintWriter(file)){
                pw.write("Mama say");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
