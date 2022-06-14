package com.softserve.edu.practice02;

public class Divide {
    private final int dividend;
    private final int divisor;

    public Divide(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }
    public int getDividend() {
        return dividend;
    }
    public int getDivisor() {
        return divisor;
    }

    public int divide() {
        int dividend = this.dividend;
        int divisor = this.divisor;
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = 0;
        while(absDividend >= absDivisor){
            long tmp = absDivisor, count = 1;
            while(tmp <= absDividend){
                tmp <<= 1;
                count <<= 1;
            }
            result += count >> 1;
            absDividend -= tmp >> 1;
        }
        return  isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}
