package com.deeparishi.javaapp.leetcode.arrays;
// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements


import java.util.Arrays;

public class LexicographicallySmallestElement {


    public static void main(String[] args) {
        int[] num1 = {1, 5, 3, 9, 8};
        int[] num2 = {1, 7, 6, 18, 2, 1};
        int[] num3 = {1, 7, 28, 19, 10};
        int[] num4 = {5,100,44,45,16,30,14,65,83,64};
//        System.out.println(Arrays.toString(lexicographicallySmallestArray(num1, 2)));
//        System.out.println(Arrays.toString(lexicographicallySmallestArray(num2, 3)));
//        System.out.println(Arrays.toString(lexicographicallySmallestArray(num3, 3)));
        System.out.println(Arrays.toString(lexicographicallySmallestArray(num4, 15)));
    }


    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {

        boolean flag;

        do {
            flag = true;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (Math.abs(nums[i] - nums[j]) <= limit && nums[i] > nums[j]) {
                        swap(nums, i, j);
                        flag = false;
                    }
                }
            }
        } while (!flag);

        return nums;
    }


    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}