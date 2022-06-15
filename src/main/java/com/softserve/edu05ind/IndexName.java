package com.softserve.edu05ind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class IndexName implements Index {
    private final int RIGHT_SHIFT = 20;
    private int maxLen;
    private Item[] items;
    private Map<Long, Integer> map;

    public IndexName(Student[] arr) {
        initItems(arr);
        initCheckSum(arr);
        sortItems();
        InitMap();
    }

    private void initItems(Student[] arr) {
        maxLen = 0;
        items = new Item[arr.length];
    }

    /*
    private void initCheckSum(Student[] arr) {
        long checkSum = 0;
        String current = null;
        //
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxLen < arr[i].getName().length()) {
                maxLen = arr[i].getName().length();
            }
        }
        //
        for (int i = 0; i < arr.length; i++) {
            checkSum = 0;
            current = arr[i].getName().toUpperCase();
            for (int j = current.length(); j < maxLen; j++) {
                current = current + "A";
            }
            for (int j = 0; j < maxLen; j++) {
                checkSum = checkSum * RIGHT_SHIFT + ((int) (current.charAt(j)) - 64);
            }
            items[i] = new Item(checkSum, i);
        }
    }
    */

    private void initMax(Student[] arr) {
        maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxLen < arr[i].getName().length()) {
                maxLen = arr[i].getName().length();
            }
        }
    }

    public long getCheckSum(String current) {
        long checkSum = 0;
        current =current.toUpperCase();
        //
        for (int j = current.length(); j < maxLen; j++) {
            current = current + "A";
        }
        for (int j = 0; j < maxLen; j++) {
            checkSum = checkSum * RIGHT_SHIFT + ((int) (current.charAt(j)) - 64);
        }
        return checkSum;
    }

    private void initCheckSum(Student[] arr) {
        long checkSum = 0;
        String current = null;
        //
        initMax(arr);
        //
        for (int i = 0; i < arr.length; i++) {
            items[i] = new Item(getCheckSum(arr[i].getName()), i);
        }
    }

    private void sortItems() {
        //System.out.println("\nBefore sort = " + Arrays.toString(items));
        Arrays.sort(items);
        //System.out.println("\nAfter sort = " + Arrays.toString(items));
    }

    private void InitMap() {
        map = new TreeMap<>();
        for (int i = 0; i< items.length; i++) {
            map.put(items[i].getCheckSum(), items[i].getIndex());
        }
    }

    public int getIndex(long checkSum) {
        return map.get(checkSum);
    }

    public int getIndex(String text) {
        return map.get(getCheckSum(text));
    }

    @Override
    public String toString() {
        return "IndexName [" +
                "items=" + Arrays.toString(items) +
                ']';
    }

}
