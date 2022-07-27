package org.example;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main(String[ ] args) throws Exception {
        A testing = new B();
        testing.test();
    }
}

class A {
    public void test() throws Exception {
        System.out.println("this is A");
    }
}

class B extends A {
    public void test() {
        System.out.println("this is B");
    }
}