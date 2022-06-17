package com.softserve.edu06rec;

import java.util.Scanner;

public class AppSum {

    public double simpleSqrt(int n) {
        double result = 0;
        for (int i = n; i >= 1; i--) {
            result = Math.sqrt(i + result);
        }
        return result;
    }

    public double recurSqrt(int i, int n) {
        if (i >= n) {
            return Math.sqrt((double) n);
        }
        return Math.sqrt(i + recurSqrt(i + 1, n));
    }

    public int simpleSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println("i = " + i + "  sum = " + sum);
            sum = sum + i;
        }
        return sum;
    }

    public int recurSum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + recurSum(n - 1);
    }

    public static void main(String[] args) {
        AppSum app = new AppSum();
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        n = sc.nextInt();
        //
        //System.out.print("sum = " + app.simpleSum(n));
        //System.out.print("sum = " + app.recurSum(n));
        //
        System.out.println("sum = " + app.simpleSqrt(n));
        System.out.println("sum = " + app.recurSqrt(1, n));
        //
        sc.close();
    }
}
