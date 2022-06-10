package com.softserve.edu04find;

import com.softserve.edu03.Person;

import java.util.Arrays;

public class ApplSearch {

    public static void main(String[] args) {
        /*
        String s1 = "abc";  // new String("abc");
        //String s2 = "abc";
        String s2 = new String("abc");
        System.out.println("(s1 == s2) = " + (s1 == s2)); // true if declared String s2 = "abc";
        System.out.println("s1.equals(s2) = " + s1.equals(s2));
        System.out.println("s1.compareTo(s2) = " + s1.compareTo(s2));
        */
        //
        /*
        int k1 = 500;
        int k2 = 500;
        System.out.println("(k1 == k2) = " + (k1 == k2)); // true
        //System.out.println("k1.equals(k2) = " + k1.equals(k2)); // Compile Error
        //
        Integer i1 = 500; // new Integer(5); cache < 128
        Integer i2 = 500;
        System.out.println("(i1 == i2) = " + (i1 == i2)); // false if i1 > 128
        System.out.println("i1.equals(i2) = " + i1.equals(i2));
        System.out.println("i1.compareTo(i2) = " + i1.compareTo(i2));
        */
        /*
        int[] arr = {101, 38, 82, 23, 99, 70, 98, 93, 15, 81};
        //
        int element = 81; // Read from console
        int position = -1;
        System.out.println("element: " + element);
        System.out.println("Original: " + Arrays.toString(arr));
        //
        for (int i = 0; i< arr.length; i++) {
            if (element == arr[i]) {
                position = i;
                break;
            }
        }
        String message = position < 0 ? "not found": "founded, position = " + position;
        System.out.println(message);
        //
        Arrays.sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
        position = Arrays.binarySearch(arr, element);
        System.out.println("Arrays.binarySearch(arr, element) = " + position);
        */
        /*
        Person[] arr = { new Person(2,"Ivan"),
                new Person(8,"Petro"),
                new Person(1,"Ivan"),
                new Person(10,"Petro"),
                new Person(11,"Ivan"),
                new Person(4,"Petro"),
                new Person(3,"Ira"),
        };
        //Person element = new Person(11,"Ivan");
        Person element = new Person(3,"Ira");
        int position = -1;
        //
        for (int i = 0; i< arr.length; i++) {
            if (element.equals(arr[i])) {
                position = i;
                break;
            }
        }
        //
        String message = position < 0 ? "not found": "founded, position = " + position;
        System.out.println(message);
        //
        position =  Arrays.binarySearch(arr, element);
        System.out.println("\nArrays.binarySearch(arr, element) = " + position);
        */
        //
        Sort sort = new Sort();
        //int[] arr = {101, 38, 82, 23, 99, 70, 98, 93, 15, 81};
        //int[] arr = {1, 2, 3, 4};
        int[] arr = {4, 3, 2, 1};
        System.out.println("Original: " + Arrays.toString(arr));
        sort.sortArray(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }

}
