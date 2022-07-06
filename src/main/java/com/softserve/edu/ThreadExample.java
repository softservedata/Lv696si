package com.softserve.edu;


import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class ThreadExample {
    public static void threadRun() {
        Interactor interactor = new Interactor();
        Thread t1 = new Thread(() -> {
            try {
                interactor.serve(x -> -x + 4, 11);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                interactor.consume((a, b) -> -a + 2 * b, 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            t2.start();
            t1.start();
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        threadRun();
    }
}

class Interactor {
    int x;

    public void serve(UnaryOperator<Integer> uo, int initializer) throws InterruptedException {
        System.out.println("Serving thread running");
        System.out.println("Serving thread initializes the key");
        x = initializer;
        System.out.println("key = " + uo.apply(initializer));

        System.out.println("Serving thread resumed");
    }

    public void consume(BinaryOperator<Integer> bo, int operand2) throws InterruptedException {
        System.out.println("Consuming thread received the key. key =" + x);
        System.out.println("Consuming thread changed the key. key = " + bo.apply(x, operand2));
    }
}