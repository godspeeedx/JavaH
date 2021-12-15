package ru.mephi.java.ch06.task04;

import java.util.ArrayList;

public class Table<K, V> {

    ArrayList<Entry> entries = new ArrayList<>();

    public V getValue(K key) {
        for (Entry en : entries) {
            if (en.key == key)
                return en.value;
        }
        return null;
    }

    public void setValue(K key, V value) {
        for (Entry en : entries) {
            if (key.equals(en.key)) {
                en.value = value;

                return;
            }
        }

        entries.add(new Entry(key, value));

    }

    public void delete(K key) {
        for (Entry en : entries) {
            if (en.key == key) {
                entries.removeIf(s -> s.key.equals(key));
                return;
            }
        }
    }

    private class Entry {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
