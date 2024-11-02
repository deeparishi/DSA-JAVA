package com.deeparishi.javaapp.leetcode.recursion;

public class GCD {

    public static void main(String[] args) {

        System.out.println(gcd(8,4));

    }

    static int gcd(int a, int n){

        if (n == 0) return a;
        return gcd(n, a % n);
    }

}
