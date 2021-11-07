package ru.mephi.java.ch03.additionalTask;

import java.util.Random;

public class ClassForCheck {
    private Random generator;

    public ClassForCheck() {
        this.generator = new Random();
    }


    public static void lak(int lack){
        System.out.println(lack);
        lack *= 10;
        System.out.println("hahhaha" + lack);
    }

    public Integer multiplyRandom(Integer x){
       double pos = generator.nextDouble();
       if(pos > 0.5){
           return (int) (pos*10*x);
       }

        return null;
    }

    public int likeComparator(int x, int y){
        int check = Integer.compare(x,y);
        if(check < 0){
            return 1;
        } else if ((check == 0)){
            return 0;
        } else {
            return -1;
        }
    }
}
