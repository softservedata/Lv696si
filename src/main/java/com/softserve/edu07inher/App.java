package com.softserve.edu07inher;

public class App {
    public static void main(String[] args) {
        //B b = new B();
        A a = new B();
        a.m1();
        //a.m2();
        A.m2();
        B.m2();
        //System.out.println("a = " + a.toString()); // a.toString();
        System.out.println("done");
    }
}
