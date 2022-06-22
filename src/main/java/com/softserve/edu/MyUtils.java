package com.softserve.edu;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;


public class MyUtils {
    public boolean verifyBrackets(String text) {
        String openBracket = "";
        String temp = "";
        for (int i = 0; i < text.length(); i++) {
            if (i > 1) {
                temp = text.substring(i - 2, i);
            }

            if ((text.charAt(i) == '(' || text.charAt(i) == '{' || text.charAt(i) == '[')
                    && !temp.equals("\\\\")) {
                openBracket = openBracket + text.charAt(i);
                continue;
            }
            if (text.charAt(i) == ')' && !temp.equals("\\\\")) {
                if (openBracket.endsWith("(") ) {
                    openBracket = openBracket.substring(0, openBracket.length() - 1);
                    continue;
                } else return false;
            }
            if (text.charAt(i) == '}' && !temp.equals("\\\\")) {
                if (openBracket.endsWith("{")) {
                    openBracket = openBracket.substring(0, openBracket.length() - 1);
                    continue;
                } else return false;
            }
            if (text.charAt(i) == ']' && !temp.equals("\\\\")) {
                if (openBracket.endsWith("[") ) {
                    openBracket = openBracket.substring(0, openBracket.length() - 1);
                    continue;
                } else return false;
            }
        }
        System.out.println(openBracket);
        return openBracket.equals("");
    }

    public static void main(String[] args) {
        MyUtils myUtils = new MyUtils();
        System.out.println("\\\\[\\\\{\\\\(");
        System.out.println(myUtils.verifyBrackets("\\\\[]\\\\{}\\\\()"));
    }
}