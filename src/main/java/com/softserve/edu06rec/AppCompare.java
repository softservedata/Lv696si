package com.softserve.edu06rec;

public class AppCompare {
    public static void main(String[] args) {
        /*
        Integer i1 = 400;
        Integer i2 = 400;
        System.out.println("(i1 == i2) = " + (i1 == i2)); // true if i1, i2 < 128
        System.out.println("(i1.compareTo(i2)) = " + (i1.compareTo(i2)));
        */
        //
        Tree tree = new Tree();
        tree.add(10).add(5).add(15).add(2).add(8).add(12).add(18).add(11).add(5).add(5);
        //tree.print();
        System.out.println("Tree = " +  tree.getList());
    }
}
