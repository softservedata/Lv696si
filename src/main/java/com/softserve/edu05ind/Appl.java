package com.softserve.edu05ind;

import java.util.Arrays;

public class Appl {
    public static void main(String[] args) {
        Student[] arr = { new Student(2,"Ivan"),
                new Student(8,"Petro"),
                new Student(1,"Stepan"),
                new Student(10,"Inna"),
                new Student(11,"Oksana"),
                new Student(4,"Natalia"),
                new Student(3,"Ira"),
        };
        IndexName indexName = new IndexName(arr);
        Student.setIndex(indexName);
        System.out.println("\nindexName = " + indexName);
        //
        //int position =  Arrays.binarySearch(arr, new Student(-1,"Natalia"));
        //int position =  Arrays.binarySearch(arr, new Student(-1,"Oksana"));
        //int position =  Arrays.binarySearch(arr, new Student(-2,"Ivan"));
        int position =  Arrays.binarySearch(arr, new Student(-1,"Stepan"));
        System.out.println("\nArrays.binarySearch(arr, element) = " + position);
    }
}
