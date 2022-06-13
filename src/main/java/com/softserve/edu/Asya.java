package com.softserve.edu;

public class Asya {
}
class Solution {
    public int divide(int dividend, int divisor) {
        boolean dividendNegative = false;
        boolean divisorNegative = false;
        long newDividend = dividend;
        long newDivisor = divisor;
        if(dividend== Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;}
        If (dividend < 0); {
            newDividend = - newDividend;
            dividendNegative = true;
        }
        if (divisor <0) {
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
            result = result +result;
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