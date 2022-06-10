package com.softserve.edu.practice02;

public class Palindrome {
    private final int x;

    public Palindrome(int x){
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public boolean isPalindrome() {
        int x = this.x;
        int valueFirst = 0;
        int valueSecond = 0;
        int valueSecondNew = 0;
        int count = 0;
        boolean res = false;

        if (x>0) {

            count = numberOfElements(x);

            if (count % 2 == 0) {
                int temp = count / 2;
                valueFirst = (int) (x / Math.pow(10, temp));
                valueSecond = (int) (x % Math.pow(10, temp));

            } else {
                int temp = count / 2;
                valueFirst = (int) (x / Math.pow(10, temp + 1));
                valueSecond = (int) (x % Math.pow(10, temp));
            }

            int countF = numberOfElements(valueFirst);
            int countS = numberOfElements(valueSecond);

            for (valueSecondNew = 0; valueSecond >= 0; valueSecond = valueSecond / 10) {
                if (valueSecond != 0) {
                    valueSecondNew += valueSecond % 10;
                    valueSecondNew *= 10;
                } else if (valueSecond == 0) {
                    int countNew = numberOfElements(valueSecondNew);
                    if(countF == countS){
                        valueSecondNew /= 10;
                    } else {
                        valueSecondNew *= Math.pow(10, countF - countS - 1);
                    }
                    break;
                }
            }
            res = valueFirst == valueSecondNew;
        } else if (x == 0) {
            res = true;
        }
        return res;
    }

    public int numberOfElements(int number){
        int count = 0;
        for (count = 0; number != 0; number = number / 10) {
            count++;
        }
        return count;
    }
}
