package ru.mephi.java.ch02.task15;

import java.util.ArrayList;
// сделать Item private class ; методы должны быть toString которые возвращают инф
public class Invoice {
    private final ArrayList<Item> items = new ArrayList<>();

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            stringBuilder.append("[");
            stringBuilder.append(items.get(i).toString());
            stringBuilder.append("]\n");
        }
        return stringBuilder.toString();
    }


    public void add(String description, int quantity, double unitPrice) {
        items.add(new Item(description, quantity, unitPrice));
    }


    private static class Item {
        private final String description;
        private final int quantity;
        private final double unitPrice;

        public Item(String description, int quantity, double unitPrice) {
            this.description = description;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Description = ");
            stringBuilder.append(this.description);
            stringBuilder.append("; quantity = ");
            stringBuilder.append(this.quantity);
            stringBuilder.append("; unit price =");
            stringBuilder.append(this.unitPrice);
            return stringBuilder.toString();
        }


    }

}
