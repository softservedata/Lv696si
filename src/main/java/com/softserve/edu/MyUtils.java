package com.softserve.edu;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyUtils {
    public String differentWords(String originalText, String modifyText) {
        String pattern = "\\b[a-zA-Z0-9]+\\b";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(originalText);
        Matcher matcher2 = p.matcher(modifyText);
        String modified = "";
        while (matcher.find()) {
            String original = originalText.substring(matcher.start(), matcher.end());
            do {
                if (matcher2.find()) {
                    modified = modifyText.substring(matcher2.start(), matcher2.end());
                    if (!original.equalsIgnoreCase(modified)) {
                        String newWord = modified.toUpperCase();
                        modifyText = modifyText.replaceFirst(modified, newWord);
                    }
                }
                else {
                    break;
                }
            }
            while (!original.equalsIgnoreCase(modified));
        }
        while (matcher2.find()) {
            modified = modifyText.substring(matcher2.start(), matcher2.end());
            String newWord = modified.toUpperCase();
            modifyText = modifyText.replaceFirst(modified, newWord);
        }

        return modifyText;
    }


    public static void main(String[] args) {
        MyUtils myUtils = new MyUtils();
        String text2 = "Fggg java fgffh java";

        /*String text2 = "";*/
        String text1 = "Java sfdfsffsf";
        System.out.println(myUtils.differentWords(text1, text2));


    }
}