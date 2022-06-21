package com.softserve.edu;

import java.util.Arrays;

public class App {
    public static int[][] arrSort(int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length == 0 && o2.length != 0)
                return 1;
            if (o1.length != 0 && o2.length == 0)
                return -1;
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
                    } else {
                        if (o1.length > 1 && o2.length <= 1) {
                            return 1;
                        }
                        if (o1.length <= 1 && o2.length > 1) {
                            return -1;
                        }
                        return 0;
                    }
                } else {
                    return -1;
                }
            }
        });
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = {{}, {1}, {1, 2, 3}, {3, 2}, {3, 3}};
        for (int[] a: arr) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("--------");
        for (int[] a: arrSort(arr)) {
            System.out.println(Arrays.toString(a));
        }

    }
}
