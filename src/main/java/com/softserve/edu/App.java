package com.softserve.edu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        int rev=0;
        int ori=x;
        if (x<0 || (x!=0 && x%10==0))
            return false;
        while(x!=0){
            rev=rev*10+x%10;
            x=x/10;
        }
        return ori==rev;
    }
}


class Solution {
    public int reverse(int x) {
        // INT_MAX: 2147483647
        // INT_MIN: -2147483648
        int result = 0;

        while (x != 0) {
            int mod = x % 10;

            if (result > 214748364 || (result == 214748364 && mod > 7)) {
                return 0;
            }
            if (result < -214748364 || (result == -214748364 && mod == -9)) {
                return 0;
            }

            result = 10 * result + mod;
            x /= 10;
        }

        return result;
    }
};
