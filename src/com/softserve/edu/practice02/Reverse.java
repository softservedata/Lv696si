package com.softserve.edu.practice02;

public class Reverse {
    private final int x;

    public Reverse(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int reverse() {
        int x = this.x;
        int signMultiplier = 1;
        if (x<0){
            signMultiplier = -1;
            x *= signMultiplier;
        }

        int res = 0;
        while(x>0){
            if (res * signMultiplier > Integer.MAX_VALUE / 10 || res * signMultiplier < Integer.MIN_VALUE / 10){
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }

        return res * signMultiplier;
    }
}
