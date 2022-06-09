package com.softserve.tasks.progaramflow.task3;

class Solution {
    public static int divide(int dividend, int divisor) {
        int add = 1;
        if (((dividend < 0) && (divisor > 0)) || ((dividend > 0) && (divisor < 0))) {
            add = -1;
        }

        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        int addition = divisor;
        int result = 0;
        while ((divisor >= dividend) && ((dividend - divisor) <= -divisor)) {
            result++;
            if (result == 2147483647) {
                break;
            }
            divisor += addition;
        }
        if (add > 0) {
            return result;
        }
        return -result;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648,-1));
    }
}