package com.eftimoff.draggableviewpager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Page {

    private List<Item> items = new ArrayList<Item>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void swapItems(int itemA, int itemB) {
        Collections.swap(items, itemA, itemB);
    }

    public Item removeItem(int itemIndex) {
        return items.remove(itemIndex);
    }

    public void deleteItem(int itemIndex) {
        items.remove(itemIndex);
    }
}
