package com.softserve.task2;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public int reverse(int x) {

        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    static int divide(int dividend, int divisor) {
        int sign
                = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0;

        while (dividend >= divisor) {
            dividend -= divisor;
            ++quotient;
        }
        if (sign == -1)
            quotient = -quotient;

        return quotient;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        System.out.println(divide(a, b));
    }

    public int mySqrt(int x) {
        long low = 0, high = x, res = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long mulMid = mid * mid;

            if (mulMid == x)
                return ((int) mid);
            if (mulMid > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
                res = mid;
            }
        }
        return ((int) res);
    }
}


