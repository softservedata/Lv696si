package com.softserve.edu;

import com.softserve.edu.practice02.Divide;
import com.softserve.edu.practice02.Palindrome;
import com.softserve.edu.practice02.Reverse;
import com.softserve.edu.practice02.SquareRoot;
import com.softserve.edu.practice03.Task2;
import com.softserve.edu.practice03.Task3;

import java.util.*;

public class Appl {
    public static void main(String[] args) {
        //PRACTICE 2
        //
        System.out.println("PRACTICE 2");
        System.out.println();
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
        //Reverse
        //
        Reverse rv = new Reverse(-1234);
        System.out.println("Revers of number " + rv.getX() + " is " + rv.reverse());
        //Divide
        //
        Divide div = new Divide(10, 3);
        System.out.println("Divide for " + div.getDividend() +
                ", " + div.getDivisor() + " is " + div.divide());
        //PRACTICE 3
        //
        System.out.println();
        System.out.println("PRACTICE 3");
        System.out.println();
        //
        //TASK1
        //
        //TASK2
        //
        System.out.println("TASK2");
        List<String> originList = new ArrayList<>();
        originList.add("zz");
        originList.add("abc");
        originList.add("aa");
        originList.add("aaa");

        Task2 task2 = new Task2(originList);
        System.out.println("ORIGINAL LIST: " + originList.toString());
        System.out.println("SORTED LIST: " + task2.strSort().toString());
        //
        //TASK3
        //
        System.out.println();
        System.out.println("TASK3");
        String[] st = {"aa", "bb", "aa", "cc"};
        List<String> stringList = new ArrayList<>(Arrays.asList(st));
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("1", "cc");
        stringMap.put("2", "bb");
        stringMap.put("3", "cc");
        stringMap.put("4", "aa");
        stringMap.put("5", "cc");

        Task3 task3 = new Task3(stringList, stringMap);
        System.out.println("List: " + stringList.toString());
        System.out.println("Map: " + stringMap.toString());
        System.out.println("Result of compare: " + task3.listMapCompare());
        System.out.println();
        //
        //TASK4
        //
        //TASK5
    }
}
