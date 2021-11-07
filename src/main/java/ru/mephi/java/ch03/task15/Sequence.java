package ru.mephi.java.ch03.task15;

import ru.mephi.java.ch03.task04.IntSequence;

import java.util.Random;

public class Sequence {
    private static final Random generator = new Random();

    public static IntSequence randomInts(int low, int high) {
            return new RandomSequence(low, high);
    }

    private static class RandomSequence implements IntSequence {
        private int low;
        private int high;

        public RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }
    }

}
