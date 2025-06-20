package com.deeparishi.javaapp.leetcode.slidingwindow;

// https://leetcode.com/problems/max-consecutive-ones-iii

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {

        int[] a = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] b = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};

        System.out.println(longestOnesV3(a, 2));
        System.out.println(longestOnesV3(b, 3));
    }

    // Optimal Approach
    public static int longestOnesV3(int[] nums, int k) {

        int left = 0;
        int right = 0;
        int zeros = 0;
        int maxLen = 0;

        while (right < nums.length) {

            if (nums[right] == 0) zeros++;

            if (zeros > k) {
                if (nums[left] == 0)
                    zeros--;
                left++;
            }
            int len = right - left + 1;
            maxLen = Math.max(len, maxLen);

            right++;
        }

        return maxLen;
    }

    // Better Approach
    public static int longestOnesV2(int[] nums, int k) {

        int maxLen = 0;
        int left = 0;
        int right = 0;
        int zeros = 0;

        while (right < nums.length) {

            if (nums[right] == 0)
                zeros++;

            while (zeros > k) {
                if (nums[left] == 0) zeros--;
                left++;
            }

            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            right++;
        }

        return maxLen;
    }

    // Brute Force Approach
    public static int longestOnesV1(int[] nums, int k) {

        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            int zeros = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0)
                    zeros++;
                if (zeros <= k) {
                    int len = j - i + 1;
                    maxLen = Math.max(maxLen, len);
                } else break;
            }
        }

        return maxLen;
    }

}