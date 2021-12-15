package ru.mephi.java.ch06.task06;

import java.util.ArrayList;

public class Move {
    public static <E> void move1(ArrayList<E> to, ArrayList<? extends E> from){
        to.addAll(from);
    }

    public static <E> void move2(ArrayList<? super E> to, ArrayList<E> from){
        to.addAll(from);
    }

}
