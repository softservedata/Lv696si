package com.softserve.edu;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.BiFunction;


public class MyUtils {
    public boolean verifyBrackets(String text) {
        List<String> openBracket = new LinkedList<>();
        String temp = "";
        for (int i = 0; i < text.length(); i++) {
            if (i > 1) {
                temp = text.substring(i - 2, i);
            }
            if (text.charAt(i) == '(' || text.charAt(i) == ')' || text.charAt(i) == '{'
        || text.charAt(i) == '}' || text.charAt(i) == ']' || text.charAt(i) == '[') {
                if (temp.equals("\\\\")) {
                    openBracket.add(temp + text.charAt(i));
                }
                else {
                    openBracket.add(text.charAt(i) + "");
                }
            }
        }
        System.out.println(openBracket);
        return false;
    }

    public static void main(String[] args) {
        MyUtils myUtils = new MyUtils();
        System.out.println(myUtils.verifyBrackets("\\\\[]\\\\{}\\\\()"));
    }
}