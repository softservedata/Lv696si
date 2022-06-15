package com.softserve.edu05ind;

import com.softserve.edu03.Person;

public class Item implements Comparable<Item> {
    private long checkSum;
    private int index;

    public Item(long checkSum, int index) {
        this.checkSum = checkSum;
        this.index = index;
    }

    public long getCheckSum() {
        return checkSum;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Item item) {
        return (int) (getCheckSum() - item.getCheckSum());
    }

    @Override
    public String toString() {
        return "\nItem [" +
                "checkSum=" + checkSum +
                ", index=" + index +
                ']';
    }
}
