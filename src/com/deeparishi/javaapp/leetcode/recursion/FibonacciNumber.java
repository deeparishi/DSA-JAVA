package com.deeparishi.javaapp.leetcode.recursion;

public class FibonacciNumber {

    public static void main(String[] args) {

        System.out.println(fibonacci(5));
        System.out.println(fibonacci(10));

        System.out.println(fibonacciV2(5));
        System.out.println(fibonacciV2(10));
    }

    public static int fibonacci(int num) {
        if (num < 0) return -1;
        if (num == 1) return 1;
        if (num == 0) return 0;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static int fibonacciV2(int num) {
        if (num < 0) return -1;
        if (num == 1) return 1;
        if (num == 0) return 0;

        int x = 0;
        int y = 1;

        for (int i = 2; i <= num; i++) {
            int curr = x + y;
            x = y;
            y = curr;
        }

        return y;
    }
}
