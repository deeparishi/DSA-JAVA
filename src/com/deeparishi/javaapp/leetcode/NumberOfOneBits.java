package com.deeparishi.javaapp.leetcode;

public class NumberOfOneBits {
    public static void main(String[] args) {

        System.out.println(hammingWeight(128));
    }

    public static int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                res += 1;
            }
        }
        return res;
    }
}
