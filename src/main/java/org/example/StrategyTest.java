package org.example;

interface Strategy {
    double doOperation(int a, int b);
}

public class StrategyTest {

    public static double execute(int a, int b, Strategy strategy) {
        return 0;
    }

    public static double addAtoB(int a, int b) {

        Strategy add = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a+b;
            }
        };
        return execute(a, b, add);
    }

    public static double subtractBfromA(int a, int b) {

        Strategy subtract = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a-b;
            }
        };
        return execute(a, b, subtract);
    }

    public static double multiplyAbyB(int a, int b) {

        Strategy multiply = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a*b;
            }
        };
        return execute(a, b, multiply);
    }

    public static double divideAbyB(int a, int b) {

        Strategy divide = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a/b;
            }
        };
        return execute(a, b, divide);
    }
}
