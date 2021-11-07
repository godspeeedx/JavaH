package ru.mephi.java.ch04.task06;

public class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        if (this.getClass() != otherObject.getClass())
            return true;
        else {
            DiscountedItem discountedItem = (DiscountedItem) otherObject;
            return this.discount == discountedItem.discount;
        }
    }

}
