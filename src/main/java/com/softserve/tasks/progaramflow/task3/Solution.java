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
        int result = 0;
        while ((dividend - divisor) <= 0) {
            result--;
            dividend -= divisor;
            if (dividend == 0) {
                break;
            }
        }
        if (add > 0) {
            if (result == -2147483648) {
                return 2147483647;
            }
            return -result;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(divide(-2147483648,1));
    }
}