package ru.mephi.java.ch03.task15;

import ru.mephi.java.ch03.task04.IntSequence;

public class Test15 {
    public static void main(String[] args) {
        IntSequence str = Sequence.randomInts(4,9);
        System.out.println(str.next());
    }
}
