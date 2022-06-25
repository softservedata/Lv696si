package com.softserve.edu;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.BiFunction;


public class MyUtils {
    public boolean verifyBrackets(String text) {
        String openBracket = "";
        String t = "";
        for (int i = 0; i < text.length(); i++) {
            String temp = "";
            if (i > 1) {
                temp = text.substring(i - 2, i);
            }
            if (text.charAt(i) == '(' || text.charAt(i) == ')' || text.charAt(i) == '{'
                    || text.charAt(i) == '}' || text.charAt(i) == ']' || text.charAt(i) == '[') {
                if (temp.equals("\\\\")) {
                    if (text.charAt(i) == '(')
                        openBracket += 'A';
                    if (text.charAt(i) == '[')
                        openBracket += 'B';
                    if (text.charAt(i) == '{')
                        openBracket += 'C';
                    if (text.charAt(i) == ')')
                        openBracket += 'D';
                    if (text.charAt(i) == ']')
                        openBracket += 'E';
                    if (text.charAt(i) == '}')
                        openBracket += 'F';
                } else {
                    openBracket+=text.charAt(i);
                }
            }
        }
        System.out.println(openBracket);
        do {
            t = openBracket.toString();
            openBracket = replaceSimpleBracket(openBracket);
            //openBracket = replaceClosedBracket(openBracket);
            //openBracket = replaceOpenBracket(openBracket);
        }
        while (!t.equals(openBracket));
        openBracket = openBracket.replaceAll("[A-F]", "");
        System.out.println(openBracket);
        return openBracket.length() == 0;
    }
    public static String replaceSimpleBracket(String text) {
        String result = text;
        String temp = text;
        do {
            temp = result.toString();
            result = result.replaceAll("\\([^\\(\\)\\[\\]\\{\\}\\]]*\\)", "");
            result = result.replaceAll("\\[[^\\(\\)\\[\\]\\{\\}\\]]*\\]", "");
            result = result.replaceAll("\\{[^\\(\\)\\[\\]\\{\\}\\]]*\\}", "");
        }
        while (!temp.equals(result));

        return result;
    }

    public static String replaceClosedBracket(String text) {
        String result = text;
        String temp = text;
        do {
            temp = result.toString();
            result = result.replaceAll("A[^\\(\\)\\[\\]\\{\\}\\]]*\\)", "");
            result = result.replaceAll("B[^\\(\\)\\[\\]\\{\\}\\]]*\\]", "");
            result = result.replaceAll("C[^\\(\\)\\[\\]\\{\\}\\]]*\\}", "");
        }
        while (!temp.equals(result));
        return result;
    }

    public static String replaceOpenBracket(String text) {
        String result = text;
        String temp = text;
        do {
            temp = result.toString();
            result = result.replaceAll("\\([^\\(\\)\\[\\]\\{\\}\\]]*D", "");
            result = result.replaceAll("\\[[^\\(\\)\\[\\]\\{\\}\\]]*E", "");
            result = result.replaceAll("\\{[^\\(\\)\\[\\]\\{\\}\\]]*F", "");
        }
        while (!temp.equals(result));
        return result;
    }

    public static void main(String[] args) {
        MyUtils myUtils = new MyUtils();
        String text = "\\\\]\\\\]\\\\[]";
        System.out.println(text);
        System.out.println(myUtils.verifyBrackets(text));
    }
}