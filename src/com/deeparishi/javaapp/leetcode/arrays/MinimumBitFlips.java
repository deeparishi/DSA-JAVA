package com.deeparishi.javaapp.leetcode.arrays;


//  Code Link -> https://leetcode.com/problems/minimum-bit-flips-to-convert-number

public class MinimumBitFlips {

    public static void main(String[] args) {
        int result = minBitFlips(3, 4);
        System.out.println(result);
    }

    public static int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;

        while (xor != 0) {
            count += xor & 1;
            xor = xor >> 1;
        }

        return count;
    }
}
