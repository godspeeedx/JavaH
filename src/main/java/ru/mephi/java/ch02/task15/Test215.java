package ru.mephi.java.ch02.task15;

public class Test215 {
    public static void main(String[] args) {
      //  Invoice.Item cat = new Invoice.Item("cat",4,100);
       // Invoice.Item dog = new Invoice.Item("dog",2,500);
      //  Invoice.Item rabbit = new Invoice.Item("rabbit",10,24);
        Invoice shopAnimals = new Invoice();
        shopAnimals.add("cat",4,100);
        shopAnimals.add("dog",2,500);
        shopAnimals.add("rabbit",10,24);
        System.out.println(shopAnimals.toString());

    }
}
