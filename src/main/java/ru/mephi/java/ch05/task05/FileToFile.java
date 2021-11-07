package ru.mephi.java.ch05.task05;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileToFile {

    public void fileToFile(String filename1, String filename2) throws Exception {
        Scanner sc = null;
        PrintWriter pw = null;
        File file = null;
        Exception ex = null;
        try {
            file = new File(filename1);
            sc = new Scanner(file);
            pw = new PrintWriter(filename2);
            while (sc.hasNext()) {
                pw.println(sc.next().toLowerCase());
            }
        } catch (Exception e) {
            ex = e;
        } finally {
            try {
                if (sc != null) {
                    sc.close();
                }
            } catch (RuntimeException e) {
                if (ex != null) {
                    ex.addSuppressed(e);
                } else {
                    ex = e;
                }
            }
            try {
                if (pw != null) {
                    pw.close();
                }
            } catch (RuntimeException e) {
                if (ex != null) {
                    ex.addSuppressed(e);
                } else {
                    ex = e;
                }
            }
        }
        if (ex != null) {
            throw ex;
        }
    }
}