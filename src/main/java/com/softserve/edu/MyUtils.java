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
                } else {
                    openBracket.add(text.charAt(i) + "");
                }
            }
        }
        for (int i = 0; i < openBracket.size(); i++) {
            if (openBracket.get(i).length() != 1) {
                continue;
            }
            String temp1 = openBracket.get(i);
            for (int j = i - 1; j >= 0; j--) {
                String temp2 = openBracket.get(j);
                if (temp2.length() == 1) {
                    if (temp2.equals("{") && temp1.equals("}")) {
                        for (int k = j; k <= i; k++)
                        {
                            openBracket.set(k, "");
                        }
                        break;
                    }
                    if (temp2.equals("[") && temp1.equals("]")) {
                        for (int k = j; k <= i; k++)
                        {
                            openBracket.set(k, "");
                        }
                        break;
                    }
                    if (temp2.equals("(") && temp1.equals(")")) {
                        for (int k = j; k <= i; k++)
                        {
                            openBracket.set(k, "");
                        }
                        break;
                    }
                    break;
                }
            }
        }
        System.out.println(openBracket.toString());
        for (int i = 0; i < openBracket.size(); i++) {
            if (openBracket.get(i).length() != 1) {
                continue;
            }
            String temp1 = openBracket.get(i);
            for (int j = i - 1; j >= 0; j--) {
                String temp2 = openBracket.get(j);
                if (temp2.length() == 3) {
                    if (temp2.equals("\\\\{") && temp1.equals("}")) {
                        for (int k = i; k >= j; k--) {
                            if (openBracket.get(k).length() != 1 || k == i)
                                openBracket.set(k, "");
                        }
                        break;
                    }
                    if (temp2.equals("\\\\[") && temp1.equals("]")) {
                        for (int k = i; k >= j; k--) {
                            if (openBracket.get(k).length() != 1 || k == i)
                                openBracket.set(k, "");
                        }
                        break;
                    }
                    if (temp2.equals("\\\\(") && temp1.equals(")")) {
                        for (int k = i; k >= j; k--) {
                            if (openBracket.get(k).length() != 1 || k == i)
                                openBracket.set(k, "");
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(openBracket.toString());
        for (int i = 0; i < openBracket.size(); i++) {
            if (openBracket.get(i).length() != 1) {
                continue;
            }
            String temp1 = openBracket.get(i);
            for (int j = i + 1; j < openBracket.size(); j++) {
                String temp2 = openBracket.get(j);
                if (temp2.length() == 3) {
                    if (temp2.equals("\\\\}") && temp1.equals("{")) {
                        for (int k = j; k >= i; k--) {
                            if (openBracket.get(k).length() != 1 || k == i)
                                openBracket.set(k, "");
                        }
                        break;
                    }
                    if (temp2.equals("\\\\]") && temp1.equals("[")) {
                        for (int k = j; k >= i; k--) {
                            if (openBracket.get(k).length() != 1 || k == i)
                                openBracket.set(k, "");
                        }
                        break;
                    }
                    if (temp2.equals("\\\\)") && temp1.equals("(")) {
                        for (int k = j; k >= i; k--) {
                            if (openBracket.get(k).length() != 1 || k == i)
                                openBracket.set(k, "");
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(openBracket.toString());
        for (int i = 0; i < openBracket.size(); i++) {
            if (openBracket.get(i).length() != 1) {
                continue;
            }
            String temp1 = openBracket.get(i);
            for (int j = i - 1; j >= 0; j--) {
                String temp2 = openBracket.get(j);
                if (temp2.length() == 1) {
                    if (temp2.equals("{") && temp1.equals("}")) {
                        openBracket.set(j, "");
                        openBracket.set(i, "");
                        break;
                    }
                    if (temp2.equals("[") && temp1.equals("]")) {
                        openBracket.set(j, "");
                        openBracket.set(i, "");
                        break;
                    }
                    if (temp2.equals("(") && temp1.equals(")")) {
                        openBracket.set(j, "");
                        openBracket.set(i, "");
                        break;
                    }
                    break;
                }
            }
        }
        System.out.println(openBracket.toString());
        boolean result = true;
        for (String str : openBracket) {
            if (str.length() == 1) {
                result = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MyUtils myUtils = new MyUtils();
        String text = "\\\\[]";
        System.out.println(text);
        System.out.println(myUtils.verifyBrackets(text));
    }
}