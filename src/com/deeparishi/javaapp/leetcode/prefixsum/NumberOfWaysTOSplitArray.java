package com.deeparishi.javaapp.leetcode.prefixsum;

// https://leetcode.com/problems/number-of-ways-to-split-array/?envType=daily-question&envId=2025-01-03

public class NumberOfWaysTOSplitArray {

    public static void main(String[] args) {

    }

    public static int waysToSplitArray(int[] nums) {

        int count = 0;
        int left = 0;

        for(int i = 0; i < nums.length - 1; i++){
            int right = 0;
            left += nums[i];
            for(int j = i + 1; j < nums.length; j++){
                right += nums[j];
            }

            if(left >= right)
                count++;
        }

        return count;
    }

    public static int waysToSplitArrayOptimized(int[] nums) {

        int count = 0;
        long totalSum = 0;

        for (int num : nums) totalSum += num;

        int left = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            long right = totalSum - left;
            if (left >= right) count++;
        }

        return count;
    }
}
