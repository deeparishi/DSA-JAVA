package com.deeparishi.javaapp.leetcode.slidingwindow;

// https://leetcode.com/problems/maximum-average-subarray-i/

public class MaxAvgSubArrayI {

    public static void main(String[] args) {
        int[] nums = {-1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(nums, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {

        int start = 0;
        int end = 0;
        double sum = 0;
        double max = Double.NEGATIVE_INFINITY;

        while (end < nums.length) {
            sum += nums[end];

            if (end - start + 1 >= k) {
                double avg = sum / k;
                max = Math.max(avg, max);
                sum -= nums[start];
                start++;
            }

            end++;
        }

        return max;
    }

    public static double findMaxAverageBruteForce(int[] nums, int k) {

        int left = 0;
        int right = k - 1;
        int len = nums.length - 1;
        double max = Integer.MIN_VALUE;

        while (right <= len) {
            double sum = 0;
            int curr = left;
            while (curr <= right)
                sum += nums[curr++];

            sum /= k;
            if (sum > max)
                max = sum;
            left++;
            right++;
        }

        return max;
    }
}
