package com.softserve.edu07inher;

public class B extends A {
    public int j = 456;

    public B() {
        //super(); // by default
        super(1);
        //System.out.println("constructor B: public B()");
        j = 579;
    }

    public void m1() {
        System.out.println("class B: public int m1()");
        super.m1();
    }

    public static void m2() {
        System.out.println("class B: public STATIC int m2()");
    }

    @Override
    public String toString() {
        return "B{" + super.toString() +
                " j = " + j +
                "}";
    }
}
