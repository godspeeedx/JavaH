package ru.mephi.java.ch02.task17;

public class Tester217 {
    public static void main(String[] args) {
        QueueWithIterator queue = new QueueWithIterator();
        QueueWithIterator.Node node1 = queue.new Node("Sasha");
        QueueWithIterator.Node node2 = queue.new Node("Masha");
        QueueWithIterator.Node node3 = queue.new Node("Glasha");
        QueueWithIterator.Node node4 = queue.new Node("Ira");
        queue.add(node1);
        queue.add(node2);
        queue.add(node3);
        queue.add(node4);
        QueueWithIterator.Iterator iterator =  queue.new Iterator();
        System.out.println(iterator.hasNext());
        for (;iterator.hasNext() != false;){
            System.out.println(iterator.next());
        }
    }
}
