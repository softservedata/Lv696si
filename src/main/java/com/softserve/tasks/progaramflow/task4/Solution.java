package com.softserve.tasks.progaramflow.task4;

public class Solution {
    public static int mySqrt(int x) {
        int result = 0;
        if (x == 1) return 1;
        if (x == 0) return 0;

        for (int i = 1; i <= 46341; i++) {
            if ((i * i) > x) {
                result = i - 1;
                break;
            }
            result = i - 1;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
    }
}
