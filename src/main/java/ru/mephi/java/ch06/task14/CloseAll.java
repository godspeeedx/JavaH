package ru.mephi.java.ch06.task14;

import java.util.ArrayList;

public class CloseAll {
    public static <T extends AutoCloseable> void closeAll
            (ArrayList<T> elem) throws Exception {
        Exception exception = null;
        for (T e : elem) {
            try {
                e.close();
            } catch (Exception ex) {
                if (exception == null) {
                    exception = ex;
                } else {
                    ex.initCause(exception);
                    exception = ex;
                }
            }
        }

        if(exception != null){
            throw exception;
        }
    }
}
