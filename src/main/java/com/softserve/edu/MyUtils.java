package com.softserve.edu;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyUtils {
    public String reformatLines(String text) {
        while (text.startsWith("\t") ||
                text.startsWith("\n") ||
                text.startsWith("\\x0B") ||
                text.startsWith("\f") ||
                text.startsWith("\r")) {
            text = text.substring(1);
        }
        text = text.replaceAll("[\\t\\n\\x0B\\f\\r]", " ");
        text = text.replaceAll("[ ]{2,}", " ");
        if (!text.endsWith(" ")) {
            text = text + " ";
        }
        String pattern = " ";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        StringBuilder result = new StringBuilder(text);
        int startIndex = 0;
        int previous = 0;
        while (m.find()) {
            if (m.start() - startIndex > 60) {
                startIndex = previous;
                result = result.replace(previous, previous + 1, "\n");
            }
            previous = m.start();
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        String result1 = result.toString();
        return result.toString();
    }


    public static void main(String[] args) {
        MyUtils myUtils = new MyUtils();
        String text1 = " \n \tJava    was      originally developed\n" +
                "   by    James   Gosling at Sun Microsystems (which\n" +
                " has since been\n" +
                "acquired by Oracle) and released in 1995\n" +
                " as a core component of Sun Microsystems' Java platform.    ";
        System.out.println(text1);
        System.out.println(myUtils.reformatLines(text1));

    }
}