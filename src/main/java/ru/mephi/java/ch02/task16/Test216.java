package ru.mephi.java.ch02.task16;

public class Test216 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Queue.Node node1 = queue.new Node("Sasha");
        Queue.Node node2 = queue.new Node("Masha");
        Queue.Node node3 = queue.new Node("Glasha");
        Queue.Node node4 = queue.new Node("Ira");
        queue.add(node1);
        queue.add(node2);
        queue.add(node3);
        queue.add(node4);
        queue.allInfo();
        queue.remove();
        System.out.println("After remove");
        queue.allInfo();
    }
}
