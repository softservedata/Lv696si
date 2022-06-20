package com.softserve.sprint03.task01;

import com.softserve.edu03.Person;

import java.util.Arrays;
import java.util.Comparator;

public class MyUtils {

    public static class TwoDimComp implements Comparator<int[]> {
        @Override
        public int compare(int[] a1, int[] a2) {
            if ((a1 == null) && (a2 == null)) {
                return 0;
            }
            if (a1 == null) {
                return -1;
            }
            if (a2 == null) {
                return 1;
            }
            int result = 0;
            if ((a1.length == 0) && (a2.length == 0)) {
                return 0;
            }
            if (a1.length == 0) {
                return 1;
            }
            if (a2.length == 0) {
                return -1;
            }
            result = -(a1[0] - a2[0]);
            if (result == 0) {
                if ((a1.length == 1) && (a2.length == 1)) {
                    return 0;
                }
                if (a1.length == 1) {
                    return -1;
                }
                if (a2.length == 1) {
                    return 1;
                }
                result = a1[1] - a2[1];
            }
            return result;
        }
    }

    // Code
    public int[][] arrSort(int[][] arr) {
        Arrays.sort(arr, new MyUtils.TwoDimComp());
        return arr;
    }

}
