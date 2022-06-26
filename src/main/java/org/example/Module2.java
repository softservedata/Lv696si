package org.example;

public class Module2 {

    public int reverse(int x) {
        long reverseNum = 0;
        int reverse = 0;
        while(x != 0){
            reverseNum = reverseNum*10 + x % 10;
            x = x / 10;
        }
        if(reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE){
            return 0;
        } else {
            reverse = (int)reverseNum;
        }
        return reverse;
    }

    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        String reverse = "";
        for (int i = str.length()-1; i > -1; i--){
            reverse += str.charAt(i);
        }
        return reverse.equals(str);
    }

    public int mySqrt(int x) {
        long index = 0;
        while(index*index <= x){
            index++;
        }
        index--;
        return (int)index;
    }

    public int divide(int dividend, int divisor) {
        boolean dividendNegative = false;
        boolean divisorNegative = false;
        long newDividend = dividend;
        long newDivisor = divisor;
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if (dividend < 0) {
            newDividend = -newDividend;
            dividendNegative = true;
        }
        if (divisor < 0) {
            newDivisor = -newDivisor;
            divisorNegative = true;
        }
        if(dividend == divisor){
            return 1;
        }
        long result = 1;
        long counter = newDivisor;
        while (counter < newDividend) {
            counter = counter + counter;
            result = result + result;
        }
        if (counter != newDividend) {
            while (counter > newDividend){
                counter -= newDivisor;
                result--;
            }
        }
        if(dividendNegative ^ divisorNegative){
            return (int)-result;
        }
        else {
            return (int)result;
        }
    }

}