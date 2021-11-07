package ru.mephi.java.ch05.task06;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Read {
    public static String read1(String filename) {
        BufferedReader in = null;
        String str = null;
        try {
            in = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);
            str = in.readLine();
            System.out.println(str);
        } catch (IOException | NullPointerException e) {
            System.err.println(e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        return str;
    }

    public static String read2(String filename) {
        BufferedReader in = null;
        String str = null;
        try {
            try {
                in = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);
                str = in.readLine();
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } catch (IOException | NullPointerException e ) {
            System.err.println(e);
        }
        return str;
    }

    public static String read3(String filename) {
        String str = null;
        try (BufferedReader in = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)) {
            str = in.readLine();
        } catch (IOException | NullPointerException e) {
            System.err.println(e);
        }
        return str;
    }

    public static void main(String[] args) {
        read1(null);
        read2("file");
        read2("file3");
    }
}
