package com.softserve.edu07inher;

public class A { //extends Object {
    private int i;

    public A() {
        //System.out.println("constructor A: public A()");
        i = 123;
    }

    public A(int i) {
        this();
        //System.out.println("constructor A: public A(int i)");
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void m1() {
        System.out.println("class A: public int m1()");
    }

    public static void m2() {
        System.out.println("class A: public STATIC int m2()");
    }

    @Override
    public String toString() {
        //System.out.println("\n toString() ftom Object: " + super.toString());
        return "A{" +
                "i = " + i +
                "}";
    }
}
