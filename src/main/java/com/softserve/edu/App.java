package com.softserve.edu;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                        { 1},
                {},
                        {3, 2},
                        {3, 3, 5}
                };
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        arr = arrSort(arr);
        System.out.println("----------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    // Code
    public static int[][] arrSort(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1.length == 0 && o2.length != 0)
                    return -1;
                if (o1.length != 0 && o2.length == 0)
                    return 1;
                if (o1.length == 0 && o2.length == 0)
                    return 0;
                if (o1[0] < o2[0]) {
                    return 1;
                } else {
                    if (o1[0] == o2[0]) {
                        if (o1.length > 1 && o2.length > 1) {
                            if (o1[1] >= o2[1]) {
                                return 1;
                            } else {
                                return -1;
                            }
                        }
                        else {
                            if (o1.length > 1 && o2.length < 1) {
                                return -1;
                            }
                            if (o1.length < 1 && o2.length > 1) {
                                return 1;
                            }
                            return 0;
                        }
                    }
                    else {
                        return -1;
                    }
                }
            }
        });
        return arr;
    }
}
