package com.softserve.edu06rec;

public class AppLim {

    public double getExp(double eps) {
        int n = 1;
        double p;
        double a = 2;
        double a0;
        do {
            a0 = a;
            n++;
            p = 1 + 1.0 / n;
            a = 1;
            for (int i = 0; i < n; i++) {
                a = a * p;
            }
        } while (Math.abs(a - a0) > eps);
        return a;
    }

    public int getFibon(int n) {
        int f0;
        int f1 = 1;
        int f = 1;
        for (int i = 1; i < n; i++) {
            f0 = f1;
            f1 = f;
            f = f0 + f1;
        }
        return f;
    }

    public int getFibonRec(int n) {
        if (n <= 1) {
            return 1;
        }
        return getFibonRec(n - 1) + getFibonRec(n - 2);
    }

    public static void main(String[] args) {
        AppLim app = new AppLim();
        /*
        System.out.println("     getExp = " + app.getExp(0.0000001));
        System.out.println("Math.exp(1) = " + Math.exp(1));
        */
        //
        System.out.println("   getFibon(10) = " + app.getFibon(10));
        System.out.println("getFibonRec(10) = " + app.getFibonRec(10));
    }
}
