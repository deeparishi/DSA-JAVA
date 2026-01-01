package com.deeparishi.javaapp.leetcode.arrays;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroesToEnd(arr);
        System.out.println(Arrays.toString(arr));
        moveZeroesToFront(new int[]{1, 3, 12, 0, 0});
    }

    public static void moveZeroesToEnd(int[] nums) {

        int point = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[point];
                nums[point] = nums[i];
                nums[i] = temp;
                point++;
            }
        }
    }

    public static void moveZeroesToFront(int[] nums) {
        int len = nums.length - 1;
        int ptr = len;

        for (int i = len; i >= 0; i--) {
            if (nums[i] != 0) {
                nums[ptr] = nums[i];
                ptr--;
            }
        }

        while (ptr >= 0)
            nums[ptr--] = 0;

        System.out.println(Arrays.toString(nums));
    }
}