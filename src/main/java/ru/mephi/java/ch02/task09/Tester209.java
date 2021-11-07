package ru.mephi.java.ch02.task09;

public class Tester209 {
    public static void main(String[] args) {
        Car bmw = new Car(10);
        bmw.addFuel(15.0);
        bmw.moveOnTheX(-1000);
        bmw.addFuel(90);
        bmw.moveOnTheX(-1000);
        System.out.println(bmw.getFuelLeft());
        System.out.println(bmw.getX());


    }
}
