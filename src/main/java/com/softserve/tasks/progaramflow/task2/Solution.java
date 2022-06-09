package com.softserve.tasks.progaramflow.task2;

class Solution {
    public static int reverse(int x) {
        int x1 = x;
        long result = 0;
        int trigger = -2;
        while (trigger < 0) {
            result = result * 10 + x % 10;
            x /= 10;
            if (Math.abs(x) < 10) {
                trigger++;
            }
        }
        if ((result > Math.pow(2, 31) - 1) || result <= -Math.pow(2, 31))
            return 0;
        if (Math.abs(x1) < 10) {
            return x1;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}