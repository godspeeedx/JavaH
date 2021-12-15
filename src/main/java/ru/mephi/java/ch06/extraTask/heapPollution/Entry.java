package ru.mephi.java.ch06.extraTask.heapPollution;

public class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        super();
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
}

