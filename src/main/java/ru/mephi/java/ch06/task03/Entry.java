package ru.mephi.java.ch06.task03;

import java.util.Objects;

public class Entry<K, V> {
    K key;
    V value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;
        Entry<?, ?> entry = (Entry<?, ?>) o;
        return getKey().equals(entry.getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
