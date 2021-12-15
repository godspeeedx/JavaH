package ru.mephi.java.ch06.task03;

import java.util.ArrayList;

public class Table<K, V> {
    private ArrayList<Entry<K, V>> entries = new ArrayList<>();
    @SuppressWarnings("unchecked")
    public V getValue(K key) {
        for (Entry i : entries) {
            if (key.equals(i.key)) {
                return (V) i.value;
            }
        }
        return null;
    }

    public void setValue(K key, V value) {
        int flag = 0;
        for (Entry i : entries) {
            if (key.equals(i.key)) {
                i.value = value;
                flag++;
            }
        }
        if (flag == 0) {
            entries.add(new Entry(key, value));
        }
    }

    public void deleteKey(K key) {
        entries.removeIf(i -> key.equals(i.key));
    }
}
