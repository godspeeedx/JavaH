package ru.mephi.java.ch02.task09;

public class Car {
    private final double kmPerLitre;
    private double fuelLeft = 0;
    private double x = 0;

    public Car() {
        this.kmPerLitre = 10;
    }

    public Car(double kmPerLitre) {
        this.kmPerLitre = kmPerLitre;
    }

    public void addFuel(double fuelCapacity) {
        this.fuelLeft += fuelCapacity;
    }


    public boolean moveOnTheX(double distant) {
        double checkDistant = fuelLeft * kmPerLitre;

        if (checkDistant < Math.abs(distant)) {
            double fuelNeed = (Math.abs(distant) - Math.abs(checkDistant)) / kmPerLitre;
            System.out.println("You need to fill the car " + fuelNeed + " litres of fuel to get to destination");
            return false;
        }
        fuelLeft = (checkDistant - Math.abs(distant)) / kmPerLitre;
        x += distant;
        return true;
    }


    public double getX() {
        return x;
    }

    public double getFuelLeft() {
        return fuelLeft;
    }

    public double getFuelConsuption() {
        return kmPerLitre;
    }
}
