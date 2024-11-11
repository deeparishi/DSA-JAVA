package com.deeparishi.javaapp.leetcode.sorting;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-gap/

public class MaximumGap {

    public static void main(String[] args) {

        System.out.println(maximumGap(new int[]{3,6,9,1}));
    }

    static int maximumGap(int[] nums) {

        Arrays.sort(nums);
        int a = 0;
        int b = 0;
        for (int i = 1; i < nums.length; i++) {
            a = nums[i] - nums[i - 1];
            b = Math.max(b, a);
        }
        return b;
    }
}
