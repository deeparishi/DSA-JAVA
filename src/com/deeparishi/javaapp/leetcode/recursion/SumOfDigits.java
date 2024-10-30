package com.deeparishi.javaapp.leetcode.recursion;

public class SumOfDigits {

    public static void main(String[] args) {
        System.out.println(sum(112));
    }

    static int sum(int num) {

        if (num == 0) return num;

        return num % 10 + sum(num / 10);
    }
}
