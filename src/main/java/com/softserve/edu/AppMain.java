package com.softserve.edu;

public class AppMain {

    /*
    public static void main(String[] args) {
        int multiplier = 10;
        class Local {
            int multiply(int number) {
                return number * multiplier;
            }
        }
        // multiplier = 5;
        int result = new Local().multiply(20);
        System.out.println("result  = " + result);
    }
    */

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("Java");
        String s = sb1.substring(1);
        System.out.println("s = " + s + "   sb1 = " + sb1);
        //
        s = "abc ";
        s = String.format(s, "1");
        System.out.printf("s = " + s);
    }
}
