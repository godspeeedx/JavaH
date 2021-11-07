package ru.mephi.java.ch01.task02;
/*
Напишите программу, вводящую целочисленное (как положительное, так и
отрицательное) значение угла и нормализующую его в пределах от 0 до 359
градусов. Попробуйте сделать это сначала с помощью операции %, а затем ме-
тода f lo o r M o d ( ).
 */

import java.util.Scanner;

public class Angle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целочисленное число: ");
        int angle = in.nextInt();
        boolean flag = false;
        if (angle < 0) {
            angle = angle * (-1);
            flag = true;

        }
        if (flag) {
            angle = 360 - (angle % 360);
        } else {
            angle = angle % 360;
        }
        System.out.printf("1st method. Angel equals : %d\n", angle);
        System.out.printf("2nd method. Angel equals : %d\n", Math.floorMod(angle, 360));

    }
}
