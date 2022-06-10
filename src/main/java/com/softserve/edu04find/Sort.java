package com.softserve.edu04find;

public class Sort {

    public void sortArray(int[] arr) {
        int temp = 0;
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            isSorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                System.out.print(".");
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println();
    }
}
