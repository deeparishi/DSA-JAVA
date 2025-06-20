package com.deeparishi.javaapp.leetcode.slidingwindow;

// https://leetcode.com/problems/max-consecutive-ones/

public class MaxConsecutiveOnesI {

    public static void main(String[] args) {

    }

    public int findMaxConsecutiveOnes(int[] nums) {

        int maxLen = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                maxLen = Math.max(maxLen, count);
            } else
                count = 0;
        }

        return maxLen;
    }
}
