package com.deeparishi.javaapp.leetcode.math;

public class SwapWithoutThirdVariable {

    public static void main(String[] args) {
        int a = 9;
        int b = 8;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
