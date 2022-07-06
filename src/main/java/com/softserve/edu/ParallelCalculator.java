package com.softserve.edu;


import java.util.function.BinaryOperator;

public class ParallelCalculator implements Runnable {
    BinaryOperator<Integer> binaryOperator;
    int operand1;
    int operand2;
    public int result;

    public ParallelCalculator(BinaryOperator<Integer> binaryOperator, int operand1, int operand2) {
        this.binaryOperator = binaryOperator;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public void run() {
        this.result = binaryOperator.apply(operand1, operand2);
    }

    public static void main(String[] args) {
        System.out.println(Accountant.sum(3, 5));
    }
}
class Accountant {
    public static int sum(int x, int y) {
        int result = 0;
        ParallelCalculator calculator = new ParallelCalculator(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }, x, y);
        Thread thread = new Thread(calculator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = calculator.result;
        return result;
    }
}