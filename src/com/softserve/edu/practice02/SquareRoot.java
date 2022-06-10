package com.softserve.edu.practice02;

public class SquareRoot {
    private final int number;

    public SquareRoot(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int mySqrt(){
        int x = this.number;
        int count = 0;
        for (int i = 1; x>0; i+=2){
            x = x - i;
            if (x>=0){ count++; }
        }
        return count;
    }
}
