package ru.mephi.java.ch04.task06;

import java.util.Objects;

public class Item {
    private String description;
    private double price;

    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof Item)) return false;
        Item other = (Item) otherObject;
        return Objects.equals(this.description, other.description)
                && this.price == other.price;
    }

}
