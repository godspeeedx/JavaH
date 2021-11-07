package ru.mephi.java.ch02.task16;

import java.util.LinkedList;

public class Queue {
    public class Node {
        private String str;

        public Node(String str) {
            this.str = str;
        }
        public String getStr(){
            return this.str;
        }
    }

   /* public static void main(String[] args) {
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
    }*/

    LinkedList<Node> nodesQueue = new LinkedList<>();

    public void add(Node node) {
        nodesQueue.add(node);
    }

    public void add(String newNode) {
        nodesQueue.add(new Node(newNode));
    }

    public void remove() {
        if (nodesQueue.size() != 0) {
            //Queue.Node buf = nodesQueue.get(0);
            Queue.Node buf = nodesQueue.remove(0);
        } else {
            System.out.println("Queue is empty");

        }

    }

    public void allInfo(){
        for (int i = 0; i < nodesQueue.size(); i++) {
            System.out.println((i+1) + " " + nodesQueue.get(i).getStr());
        }
    }
}
