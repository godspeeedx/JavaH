package ru.mephi.java.ch03.task05;

public class Test05 {
    public static void main(String[] args) {

        IntSequence constant = IntSequence.constant1(10);
        int i = 0;
        int k = 15;
        while (constant.hasNext() && i < k) {
            System.out.print(constant.next() + " ");
            i++;
        }
        i = 0;
        System.out.println("----------------------------------------------------");
        IntSequence lambdaConst = IntSequence.constant2(1);
        while (lambdaConst.hasNext() && i < k) {
            System.out.print(lambdaConst.next() + " ");
            i++;
        }
    }
}

