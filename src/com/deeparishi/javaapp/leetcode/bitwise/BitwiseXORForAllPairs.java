package com.deeparishi.javaapp.leetcode.bitwise;

// https://leetcode.com/problems/bitwise-xor-of-all-pairings

import java.util.Arrays;

public class BitwiseXORForAllPairs {

    public static void main(String[] args) {

        int[] a = {2, 1, 3};
        int[] b = {10, 2, 5, 0};

        System.out.println(xorAllNumbV2(a, b)); // 13
    }

    // Optimal Approach
    public static int xorAllNumbV2(int[] nums1, int[] nums2) {

        int xor = 0;

        if(nums2.length % 2 != 0) {
            for (int num : nums1) xor ^= num;
        }

        if(nums1.length % 2 != 0) {
            for (int num : nums2) xor ^= num;
        }

        return xor;
    }

    // Brute Force Approach
    public static int xorAllNumbV1(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length * nums2.length];
        int counter = 0;

        for (int k : nums1) {
            for (int i : nums2)
                arr[counter++] = k ^ i;
        }

        int sum = 0;

        for (int j : arr) sum ^= j;

        System.out.println(Arrays.toString(arr));
        return sum;
    }
}
