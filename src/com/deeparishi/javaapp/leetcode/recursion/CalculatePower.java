package com.deeparishi.javaapp.leetcode.recursion;


public class CalculatePower {

    public static void main(String[] args) {
        System.out.println(powers(12, 21));
    }


    // From Udemy
    static int pow(int base, int exp) {
        if (exp == 0) return 1;
        return base * pow(2, exp - 1);
    }


    //https://www.geeksforgeeks.org/problems/power-of-numbers-1587115620/1?page=1&category=Recursion&sortBy=submissions
    static final int MOD = 1000000007;
    static long powers(int N, int R) {
        if (R == 1) return 1;
        long val = powers(N, R / 2) % MOD;
        return (R % 2 == 0) ? (val * val) % MOD : (N * ((val * val) % MOD)) % MOD;

    }
}
