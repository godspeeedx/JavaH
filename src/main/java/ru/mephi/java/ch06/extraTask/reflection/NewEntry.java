package ru.mephi.java.ch06.extraTask.reflection;


import ru.mephi.java.ch03.task01.Employee;
import ru.mephi.java.ch06.task03.Entry;

import java.util.Objects;

public class NewEntry<K extends Entry & Comparable<? extends Entry>, V> {
    K key;
    V value;
    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ru.mephi.java.ch06.task03.Entry)) return false;
        ru.mephi.java.ch06.task03.Entry<?, ?> entry = (ru.mephi.java.ch06.task03.Entry<?, ?>) o;
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

    public NewEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
