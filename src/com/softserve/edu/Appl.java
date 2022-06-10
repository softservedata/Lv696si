package com.softserve.edu;

import com.softserve.edu.practice02.Palindrome;

public class Appl {
    public static void main(String[] args) {
        //isPalindrome
        Palindrome p = new Palindrome(1441);
        System.out.println("Number " + p.getX() + " is palindrome: "
                + p.isPalindrome());
    }
}
