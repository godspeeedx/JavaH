package ru.mephi.java.ch06.task04;

public class Test {
    public static void main(String[] args) {
        Table<Integer, String> table = new Table<>();
        table.setValue(10, "fdg");
        table.setValue(10, "fd423");
        table.setValue(12, "fd423");
        table.setValue(18, "fd3423");
        System.out.println(table.getValue(10));
        System.out.println(table.getValue(18));
        System.out.println(table.getValue(12));
        table.delete(18);
        System.out.println(table.getValue(18));
    }
}
