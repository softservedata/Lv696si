package com.softserve.edu;

import com.softserve.edu.practice02.Palindrome;
import com.softserve.edu.practice02.SquareRoot;

public class Appl {
    public static void main(String[] args) {
        //isPalindrome
        //
        Palindrome p = new Palindrome(1441);
        System.out.println("Number " + p.getX() + " is palindrome: "
                + p.isPalindrome());
        //Square Root
        //
        SquareRoot sqrt = new SquareRoot(15);
        System.out.println("Square root of " +
                sqrt.getNumber() + " is " + sqrt.mySqrt());

    }
}
