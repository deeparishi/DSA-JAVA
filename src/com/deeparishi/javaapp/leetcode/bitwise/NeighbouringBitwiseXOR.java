package com.deeparishi.javaapp.leetcode.bitwise;

// https://leetcode.com/problems/neighboring-bitwise-xor

public class NeighbouringBitwiseXOR {

    public static void main(String[] args) {

        System.out.println(doesValidBinaryArrayExistV1(new int[] {1, 1, 0}));
        System.out.println(doesValidBinaryArrayExistV1(new int[] {1, 1}));
        System.out.println(doesValidBinaryArrayExistV1(new int[] {1, 0}));

    }

    public static boolean doesValidArrayExistV2(int[] derived) {

        int step = 0;

        for (int v : derived) step ^= v;

        return step == 0;
    }

    public static boolean doesValidBinaryArrayExistV1(int[] derived) {

        int n = derived.length;

        for (int j = 0; j <= 1; j++) {

            int[] original = new int[n];
            original[0] = j;

            for (int k = 0; k < n - 1; k++)
                original[k + 1] = derived[k] ^ original[k];

            if ((original[n - 1] ^ original[0]) == derived[n - 1])
                return true;
        }

        return false;
    }


}
