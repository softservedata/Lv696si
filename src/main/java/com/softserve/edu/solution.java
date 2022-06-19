package com.softserve.edu;
class Solution {
    public boolean isPalindrome(int x) {
        int temp = 0;
        int a = x;
        if (x < 0) return false;
        while (x != 0) {
            temp = temp * 10 + x % 10;
            x /= 10;
        }
        if (a == temp) {
            return true;
        }
        return false;
    }

    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10) return 0;
            int tmp = x % 10;
            ans = 10 * ans + tmp;
            x = x / 10;
        }
        return ans;
    }

    public int divide(int dividend, int divisor)
    {
        if(dividend==-2147483648 && divisor==-2147483648)
        {
            return 1;
        }
        else if(dividend==-2147483648 && divisor < 0)
        {
            return (dividend+1)/divisor;
        }
        else if(dividend==-2147483647 && divisor > 0)
        {
            return (dividend+1)/divisor;
        }

        else
        {
            return dividend/divisor;
        }
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        int start = 1, end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}




