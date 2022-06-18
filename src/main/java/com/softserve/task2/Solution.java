package com.softserve.task2;

class Solution {
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

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) res;
        }

        public int mySqrt ( int x){
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
}