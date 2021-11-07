package ru.mephi.java.ch02.task03;

public class Tester203 {
    public static void main(String[] args) {
        System.out.println("hello");
        CreateMethods check = new CreateMethods();
        check.add("Иван");
        check.add("Олег");
        String first_name = check.add("Кристина");
        check.allString();
        System.out.println(first_name);
    }
}
