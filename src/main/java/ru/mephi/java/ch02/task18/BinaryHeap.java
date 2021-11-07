package ru.mephi.java.ch02.task18;

import java.util.ArrayList;

public class BinaryHeap {
    private ArrayList<Integer> list = new ArrayList<>();
    private int heapSize = 0;

    public void add(int numb) {
        list.add(numb);
        heapSize += 1;
        int i = heapSize - 1;
        int parent = (i - 1) / 2;
        while (i > 0 && list.get(parent) < list.get(i)) {
            int buf = list.get(i);
            list.set(i, list.get(parent));
            list.set(parent, buf);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    private void arrangeHeap(int i) {
        int leftChild;
        int rightChild;
        int largestChild;

        for (; ; ) {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            if (leftChild < heapSize && list.get(leftChild) > list.get(largestChild)) {
                largestChild = leftChild;
            }
            if (rightChild < heapSize && list.get(rightChild) > list.get(largestChild)) {
                largestChild = rightChild;
            }
            if (largestChild == i) {
                break;
            }
            int buf = list.get(largestChild);
            list.set(largestChild, list.get(i));
            list.set(i, buf);
            i = largestChild;
        }


    }

    public int getMax() {
        int buf = list.get(0);
        list.set(0, list.get(heapSize - 1));
        list.remove(heapSize - 1);
        heapSize -= 1;
        arrangeHeap(0);
        return buf;
    }

}
    /*public void getInfo() {
        if (heapSize != 0) {
            String firstNumb = this.list.get(0).toString();
            int k = firstNumb.length();
            StringBuilder maxLength = new StringBuilder();
            for (int i = 1; i < k; i++) {
                maxLength.append(" ");
            }

            int high = 1;
            for (int i = 0; ; i = 2*i+1) {
                if (2*i + 1 < heapSize){
                    high +=1;
                }
                else {
                    break;
                }
            }
            String[] str = new String[high];
            str[0] = maxLength.toString();
            for (int i = 1; i < high; i++) {
                str[i] = str[i-1] + str[i-1];
            }
            System.out.println(str[high - 1] + list.get(0));
            for (int i = 1; i < high; i++) {
                int firstOnHigh = (int) Math.pow(2,i -1);
                int lastOnHigh = (int) Math.pow(2,i) + 1;
                for (int j = 0; j < lastOnHigh; j++) {
                    if (firstOnHigh + j < heapSize) {
                        System.out.print(str[high - 1 - i] + list.get(firstOnHigh + j).toString() + str[high - i -1]);
                    }
                }
                System.out.println();
            }

        }
    }*/