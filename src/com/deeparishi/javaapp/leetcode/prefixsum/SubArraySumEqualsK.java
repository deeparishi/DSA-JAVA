package com.deeparishi.javaapp.leetcode.prefixsum;

public class SubArraySumEqualsK {

    // https://leetcode.com/problems/subarray-sum-equals-k

    public static void main(String[] args) {

        System.out.println(subArraySumBruteForce(new int[]{1, 2, 3, -3, 1, 1, 1, 4, 2, -3}, 3));

    }

    // Works on both positive and negative cases
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

    // Works only for Positive cases
    public static int subArraySumV2(int[] arr, int k) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while (right < arr.length) {
            sum += arr[right++];
            while (k > sum && left < right) {
                sum -= arr[left++];
            }

            if (k == sum) {
                count++;
                sum -= arr[left++];
            }
        }

        return count;
    }
}
