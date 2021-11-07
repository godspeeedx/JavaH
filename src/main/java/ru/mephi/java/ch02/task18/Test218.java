package ru.mephi.java.ch02.task18;

public class Test218 {
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap();
        int[] mas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < mas.length; i++){
            binaryHeap.add(mas[i]);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(binaryHeap.getMax());
        }
        for (int i = 11; i < 16; i++) {
            binaryHeap.add(i);

        }
        while (binaryHeap.getHeapSize() != 0){
            int i = binaryHeap.getMax();
            System.out.println(i);
        }

    }

}
