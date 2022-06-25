package com.softserve.edu;




public class MyUtils {
    public boolean verifyBrackets(String text) {
        String openBracket = "";

        for (int i = 0; i < text.length(); i++) {
            String temp = "";
            if (i > 1) {
                temp = text.substring(i - 2, i);
            }
            if (text.charAt(i) == '(' || text.charAt(i) == ')' || text.charAt(i) == '{'
                    || text.charAt(i) == '}' || text.charAt(i) == ']' || text.charAt(i) == '[') {
                if (!temp.equals("\\\\")) {
                    openBracket += text.charAt(i);
                }
            }
        }
        openBracket = replaceSimpleBracket(openBracket);
        System.out.println(openBracket);
        return openBracket.length() == 0;
    }

    public static String replaceSimpleBracket(String text) {
        String result = text;
        String temp = text;
        do {
            temp = result;
            result = result.replaceAll("\\([^\\(\\)\\[\\]\\{\\}]*\\)", "");
            result = result.replaceAll("\\[[^\\(\\)\\[\\]\\{\\}]*\\]", "");
            result = result.replaceAll("\\{[^\\(\\)\\[\\]\\{\\}]*\\}", "");
        }
        while (!temp.equals(result));
        return result;
    }

   /* public static String replaceClosedBracket(String text) {
        String result = text;
        String temp = text;
        do {
            temp = result;
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
            temp = result;
            result = result.replaceAll("\\([^\\(\\)\\[\\]\\{\\}\\]]*D", "");
            result = result.replaceAll("\\[[^\\(\\)\\[\\]\\{\\}\\]]*E", "");
            result = result.replaceAll("\\{[^\\(\\)\\[\\]\\{\\}\\]]*F", "");
        }
        while (!temp.equals(result));
        return result;
    }*/

    public static void main(String[] args) {
        MyUtils myUtils = new MyUtils();
        String text = "{[][({}())[])]}";
        System.out.println(text);
        System.out.println(myUtils.verifyBrackets(text));
    }
}