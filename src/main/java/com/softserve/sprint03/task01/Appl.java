package com.softserve.sprint03.task01;

import java.util.Arrays;

public class Appl {

    //public static void

    public static void main(String[] args) {
        MyUtils mu = new MyUtils();
        /*
        int[][] arr = {{1, 2, 3},
                {1, 4},
                {3, 2},
                {3, 3, 5}
        };
        */
        int[][] arr = {{}, {2}};
        System.out.println("Original Array = " + Arrays.deepToString(arr));
        arr = mu.arrSort(arr);
        System.out.println("Sorted Array = " + Arrays.deepToString(arr));
    }
}
