package ru.mephi.java.ch02.task17;

import java.util.LinkedList;

public class QueueWithIterator {
    public class Node {
        private String str;

        public Node(String str) {
            this.str = str;
        }

        public String getStr() {
            return this.str;
        }
    }

    LinkedList<Node> nodesQueue = new LinkedList<>();
    private long length = 0;

    /* public static void main(String[] args) {
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
             System.out.println(iterator.next().getStr());
         }
     }*/
    public void add(Node node) {
        nodesQueue.add(node);
        length += 1;
    }

    public QueueWithIterator.Node remove() {
        if (nodesQueue.size() != 0) {
            QueueWithIterator.Node buf = nodesQueue.remove(0);
            this.length -= 1;
            return buf;
        } else {
            System.out.println("Queue is empty");
            return null;
        }
    }

    public class Iterator {
        int k;
        public Iterator() {
            k = -1;

        }

        public boolean hasNext() {
            if (k + 1 < length) {
                return true;
            } else {
                return false;
            }
        }

        public String next() {
            if (k + 1 <length) {
                k++;
                return nodesQueue.get(k).str;
            } else {
                return null;
            }
        }


    }
}
