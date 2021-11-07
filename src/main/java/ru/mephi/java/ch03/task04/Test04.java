package ru.mephi.java.ch03.task04;

public class Test04 {
    public static void main(String[] args) {

        /*IntSequence intSequence = IntSequence.digitsOf(2, 4, 6, 7);
        if (intSequence instanceof DigitSequence)
        {
            DigitSequence digitSequence = (DigitSequence) intSequence;
            digitSequence.getSequence();
        }*/

       IntSequence seq1 = IntSequence.of1(2, 4, 6, 70);
       while (seq1.hasNext()){
           System.out.println(seq1.next());
       }
        System.out.println("----------------------------");
        IntSequence seq2 = IntSequence.of2(2, 4, 60, 7);
        while (seq2.hasNext()){
            System.out.println(seq2.next());
        }

    }
}
