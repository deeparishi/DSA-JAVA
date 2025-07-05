package com.deeparishi.javaapp.leetcode.prefixsum;

public class SubArraySumEqualsK {

    // https://leetcode.com/problems/subarray-sum-equals-k

    public static void main(String[] args) {

        System.out.println(subArraySumBruteForce(new int[]{1, 2, 3, -3, 1, 1, 1, 4, 2, -3}, 3));

    }

    public static int subArraySumBruteForce(int[] num, int k) {

        int count = 0;

        for (int i = 0; i < num.length; i++) {
            int temp = 0;
            for (int j = i; j < num.length; j++) {
                temp += num[j];
                if (temp == k)
                    count++;
            }
        }
        return count;
    }
}
