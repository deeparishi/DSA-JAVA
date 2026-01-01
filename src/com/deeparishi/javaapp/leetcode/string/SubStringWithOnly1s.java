package com.deeparishi.javaapp.leetcode.string;

// https://leetcode.com/problems/number-of-substrings-with-only-1s/

public class SubStringWithOnly1s {

    public static void main(String[] args) {

        System.out.println(numSubV1("0110111"));
        System.out.println(numSubV1("101"));
        System.out.println(numSubV1("111111"));
    }


    public static int numSub(String s) {
        long total = 0;
        long count = 0;
        int MOD = 1_000_000_007;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count++;
                total = (total + count) % MOD;
            } else
                count = 0;
        }

        return (int) total;
    }

    // Not feasible on large set of string
    public static int numSubV1(String s) {
        int total = 0;
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count++;
                total += count;
            } else
                count = 0;
        }

        return total;
    }
}