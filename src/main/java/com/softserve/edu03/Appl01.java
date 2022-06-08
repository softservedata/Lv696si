package com.softserve.edu03;

public class Appl01 {

    public static void main(String[] args) {
        System.out.println("Start");
        byte b = 127;
        System.out.printf("\nb = " + b + " b as hex = %h", b);
        b = (byte) (b + 1);  // 1 - int
        System.out.printf("\nb = " + b + " b as hex = %h", b);
        int i = b;
        i = i & 0x000000FF;
        System.out.printf("\ni = " + i + " i as hex = %h", i);
        i = i >> 2;
        System.out.printf("\ni = " + i + " i as hex = %h", i);
    }

}
