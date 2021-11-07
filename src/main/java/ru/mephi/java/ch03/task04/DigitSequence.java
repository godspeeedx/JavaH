package ru.mephi.java.ch03.task04;

import java.util.ArrayList;

public class DigitSequence implements IntSequence {
    ArrayList<Integer> numb;

    public DigitSequence(ArrayList<Integer> numb) {
        this.numb = numb;
    }


    public static void printSequence(IntSequence numb){
        if(numb.hasNext())
        System.out.print("[" + numb.next());
        while (numb.hasNext()){
            System.out.print(", "+numb.next());
        }
        System.out.println("]");
    }
    @Override
    public boolean hasNext() {
        if (numb.size() != 0) {
            return true;
        }
        return false;
    }

    @Override
    public int next() {
        int result = numb.get(0);
        numb.remove(0);
        return result;
    }

}
