package ru.mephi.java.ch03.task04;

import java.util.ArrayList;

public interface IntSequence {
    boolean hasNext();

    int next();

     static IntSequence of1(int... seq) { // 1,6,8,9,10
         ArrayList<Integer> arrayList = new ArrayList<>();


        for (int s : seq) {
            arrayList.add(s);
        }

        return new DigitSequence(arrayList);
    }


    static IntSequence of2(int... seq) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int s : seq) {
            arrayList.add(s);
        }
        return new IntSequence() {
            ArrayList<Integer> numb = arrayList;
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

        };

    }
}
