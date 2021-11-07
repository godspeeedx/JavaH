package ru.mephi.java.ch05.addTask;

import java.util.ArrayList;
import java.util.Arrays;

public class Suppressed {
// возврат либо код ошибки либо исключение но должно быть одинкаовое кол-во кода
// Снаружи я долджен использовать // подумать
    public static void main(String[] args) {

        try {
            suprMethod(null);
        } catch (Exception e) {
           // e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getSuppressed()));
        }

    }

    public static void suprMethod(ArrayList<Double> doubles) throws Exception{
        Exception t = null;
        ArrayList<Double> newMass;
        try{
            newMass = doubles;
            newMass.set(2, newMass.get(1)/4);
        } catch (RuntimeException ex){
            t = ex;
            throw ex;
        } finally {
            Exception n = new Exception();
            if(t != null)
                t.addSuppressed(n);
        }
      //  throw t;
    }
}
