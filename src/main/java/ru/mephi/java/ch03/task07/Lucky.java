package ru.mephi.java.ch03.task07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Lucky {




    public int luckySort(ArrayList<String> strings, Comparator<String> comp) {
       int i = 0;
        boolean l = true;
        pl:
        while (l) {
            i++;
            Collections.shuffle(strings);
            for (int j = 0; j < (strings.size() - 1); j++) {
                if (comp.compare(strings.get(j), strings.get(j + 1)) > 0) {
                    continue pl;
                }

            }
            l = false;


        }
        return i;
    }
}
