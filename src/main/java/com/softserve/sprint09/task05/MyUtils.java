package com.softserve.sprint09.task05;

public class MyUtils {
    public static void main(String[] args) {
        MyUtils mu = new MyUtils();
        String text = "Java    was      originally developed\n" +
                "   by    James   Gosling at Sun Microsystems (which\n" +
                " has since been\n" +
                "acquired by Oracle) and released in 1995\n" +
                " as a core component of Sun Microsystems' Java platform.";
        String result = mu.reformatLines(text);
        System.out.println(text);
        System.out.println(result);
    }

    public String reformatLines(String text) {
        // Code
        String result = "";
        //text = text.replaceAll("\r|\n|(\r\n)+", " ");
        text = text.replaceAll("\\s+", " ");
        text = text + " ";
        int k = text.length() > 60 ? 60 : text.length();
        while ((k = text.lastIndexOf(" ", k)) > 0) {
            result = result + text.substring(0,k) + "\n";
            text = text.substring(k+1);
            k = text.length() > 60 ? 60 : text.length();
        }
        return result.trim();
    }
}
