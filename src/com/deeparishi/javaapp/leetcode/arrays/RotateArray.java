package com.deeparishi.javaapp.leetcode.arrays;

//https://leetcode.com/problems/rotate-array/

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateOptimized(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    static void rotate(int[] nums, int k) {

        if(nums.length == 0 || k % nums.length == 0)
            return;

        k %= nums.length;

        while (k > 0) {
            int last = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = last;
            k--;
        }

    }


    static void rotateOptimized(int[] nums, int k) {
        if (nums.length == 0 || k % nums.length == 0) return;

        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
