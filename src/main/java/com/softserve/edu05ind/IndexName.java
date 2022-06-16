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
    Student[] arr = null;

    public IndexName(Student[] arr) {
        initItems(arr);
        initCheckSum(arr);
        sortItems();
        InitMap();
    }

    private void initItems(Student[] arr) {
        maxLen = 0;
        this.arr = arr;
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
        current = current.toUpperCase();
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
        for (int i = 0; i < items.length; i++) {
            map.put(items[i].getCheckSum(), items[i].getIndex());
        }
    }

    public int getIndex(long checkSum) {
        return map.get(checkSum);
    }

    public int getIndex(String text) {
        return map.get(getCheckSum(text));
    }

    public int binarySearch(String name) {
        int result = -1;
        int begin = 0;
        int end = items.length - 1;
        int avg = -1;
        int compare;
        //
        do {
            avg = (begin + end) / 2;
            compare = arr[items[avg].getIndex()].getName().compareTo(name);
            //
            System.out.println("avg = " + avg + "  Student = " + arr[items[avg].getIndex()]);
            //
            if (compare == 0) {
                result = avg;
                break;
            } else if (compare > 0) {
                end = avg - 1;
            } else {
                begin = avg + 1;
            }
        } while (begin <= end);
        return (result < 0 ? result : items[result].getIndex());
    }

    public int directSearch(String name) {
        int result = -1;
        for (int i = 0; i< arr.length; i++) {
            System.out.println("i = " + i + "  Student = " + arr[i]);
            if (arr[i].getName().compareTo(name) == 0) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "IndexName [" +
                "items=" + Arrays.toString(items) +
                ']';
    }

}
