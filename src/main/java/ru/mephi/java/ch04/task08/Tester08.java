package ru.mephi.java.ch04.task08;

import java.util.HashSet;
import java.util.function.Function;

public class Tester08 {
    public static void main(String[] args) {
        Person<Integer> person = new Person<Integer>(2, "Me");
        BagPack peugeot = new BagPack("ADIDAS");
        BagPack.Perse seat = peugeot.new Perse();

        Class<int[]> arr = int[].class;
        Class<Boolean> primt = boolean.class;
        Class gener = person.getClass();
        Class nestd = seat.getClass();

        System.out.println("\n Names");
        PrintName.printNameOfClasses(arr, primt, gener, nestd, Class::getName);

        System.out.println("\n Simple Names");
        PrintName.printNameOfClasses(arr, primt, gener, nestd, Class::getSimpleName);

        System.out.println("\n Canonical Names");
        PrintName.printNameOfClasses(arr, primt, gener, nestd, Class::getCanonicalName);

        System.out.println("\n Type Names");
        PrintName.printNameOfClasses(arr, primt, gener, nestd, Class::getTypeName);

        System.out.println("\n Simple Strings");  //аналогично nestd.toString()  просто nestd
        PrintName.printNameOfClasses(arr, primt, gener, nestd, Class::toString);

        System.out.println("\n Generic Strings");
        PrintName.printNameOfClasses(arr, primt, gener, nestd, Class::toGenericString);

    }

}
