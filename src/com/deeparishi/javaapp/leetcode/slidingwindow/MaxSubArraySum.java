package com.deeparishi.javaapp.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k
public class MaxSubArraySum {

    public static void main(String[] args) {
        int[] arr = {9, 9, 9, 9};
        System.out.println(maximumSubArraySumBrute(arr, 3));
        arr = new int[]{2, 4, 1, 5};
        System.out.println(maximumSubArraySumBrute(arr, 3));
    }

    public static long maximumSubArraySum(int[] nums, int k) {

        Map<Integer, Integer> lookup = new HashMap<>();

        int start = 0;
        int end = 0;
        long sum = 0;
        long max = 0;

        while (end < nums.length) {
            sum += nums[end];
            lookup.put(nums[end], lookup.getOrDefault(nums[end], 0) + 1);

            if (end - start + 1 > k) {
                int startNum = nums[start];
                sum -= startNum;
                lookup.put(startNum, lookup.get(startNum) - 1);
                if (lookup.get(startNum) == 0)
                    lookup.remove(startNum);
                start++;
            }

            if (end - start + 1 == k && lookup.size() == k) {
                max = Math.max(sum, max);
            }
            end++;
        }

        return max;
    }

    public static long maximumSubArraySumBrute(int[] nums, int k) {

        Set<Integer> window = new HashSet<>();
        int left = 0;
        int right = 0;
        long max = 0;
        int sum = 0;

        while (right < nums.length) {
            int val = nums[right];
            while (window.contains(val)) {
                window.remove(val);
                sum -= val;
                left++;
            }

            window.add(val);
            sum += val;

            if (right - left + 1 == k) {
                max = Math.max(max, sum);
                window.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return max;
    }

}
