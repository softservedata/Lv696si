package com.softserve.edu03;

import java.util.Arrays;
import java.util.Scanner;

public class AppArr {

    public static void main(String[] args) throws InterruptedException {
        /*
        for (int i=0; i<100; i++) {
            System.out.print("o");
            System.err.print("_");
            Thread.sleep(1);
        }
        */
        //
        /*
        int n = 0;
        int[] arr = null;
        //
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        n = sc.nextInt();
        arr = new int[n];
        arr[0] = 101;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        //
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        //
        sc.close();
        */
        //
        /*
        int[] arr0 = new int[] { 101, 38, 82, 23, 99, 70, 98, 93, 15, 81 };
        int[] arr = {101, 38, 82, 23, 99, 70, 98, 93, 15, 81};
        //
        //for (int i = 0; i < arr.length; i++) {
        //    System.out.print(arr[i] + "  ");
        //}
        //System.out.println("arr = " + arr.toString()); // toString();
        //System.out.println("arr = " + Arrays.toString(arr));
        //
        boolean isEquals = (arr0.length == arr.length);
//        if (arr0.length == arr.length) {
//            isEquals = true;
//        } else {
//            isEquals = false;
//        }
        //
        for (int i = 0; isEquals && i < arr.length; i++) {
            isEquals = arr[i] == arr0[i];
        }
        System.out.println("isEquals = " + isEquals);
        System.out.println("Arrays.equals(arr, arr0) = " + Arrays.equals(arr, arr0));
        */
        /*
        Person p1= new Person(2,"Ivan");
        Person p2= new Person(2,"Ivan");
        //
        System.out.println("p1 = " + p1.toString());
        System.out.println("p2 = " + p2);
        System.out.println("(p1 == p2) = " + (p1 == p2));
        System.out.println("p1.equals(p2) = " + p1.equals(p2));
        System.out.println("p1 = " + p1.hashCode());
        System.out.println("p2 = " + p2.hashCode());
        */
        //
        //  /*
        Person[] arr = { new Person(2,"Ivan"), new Person(8,"Petro") };
        Person[] arr0 = { new Person(2,"Ivan"), new Person(8,"Petro") };
        //
        boolean isEquals = (arr0.length == arr.length);
        for (int i = 0; isEquals && i < arr.length; i++) {
            //isEquals = arr[i] == arr0[i];
            isEquals = arr[i].equals(arr0[i]);
        }
        System.out.println("isEquals = " + isEquals);
        System.out.println("Arrays.equals(arr, arr0) = " + Arrays.equals(arr, arr0));
        // */
    }
}
