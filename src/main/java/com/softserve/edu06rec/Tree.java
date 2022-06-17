package com.softserve.edu06rec;

import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public Tree() {
        root = null;
    }

    public Tree add(T data) {
        Node<T> temp = root;
        Node<T> node = new Node<>();
        node.data = data;
        node.left = null;
        node.right = null;
        //
        if (root == null) {
            root = node;
        } else {
            while (temp != null) {
                if (data.compareTo(temp.data) < 0) {
                    if (temp.left == null) {
                        temp.left = node;
                        temp = temp.left;
                    }
                    temp = temp.left;
                } else {
                    if (temp.right == null) {
                        temp.right = node;
                        temp = temp.right;
                    }
                    temp = temp.right;
                }
            }
        }
        return this;
    }

    private void printRecur(Node<T> temp) {
        if (temp.left != null) {
            printRecur(temp.left);
        }
        System.out.print("  " + temp.data);
        if (temp.right != null) {
            printRecur(temp.right);
        }
    }

    public void print() {
        printRecur(root);
    }

    private void getRecur(Node<T> temp, List<T> result) {
        if (temp.left != null) {
            getRecur(temp.left, result);
        }
        result.add(temp.data);
        if (temp.right != null) {
            getRecur(temp.right, result);
        }
    }

    public List<T> getList() {
        List<T> result = new ArrayList<>();
        getRecur(root, result);
        return result;
    }
}
