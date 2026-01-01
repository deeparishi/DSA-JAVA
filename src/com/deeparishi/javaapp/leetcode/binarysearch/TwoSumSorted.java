package com.deeparishi.javaapp.leetcode.binarysearch;

import java.util.Arrays;


// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

public class TwoSumSorted {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumUsingTwoPointer(new int[]{-5, -3, 0, 2, 4, 6, 8}, 5)));
        System.out.println(Arrays.toString(twoSumUsingTwoPointer(new int[]{2, 3, 4, 7, 11, 15}, 9)));
    }

    public static int[] twoSumUsingBinarySearch(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            int start = i + 1;
            int end = arr.length - 1;
            int required = target - arr[i];

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == required)
                    return new int[]{i, mid};

                if (arr[mid] < required) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return new int[]{0, 0};
    }

    public static int[] twoSumUsingTwoPointer(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            if (sum > target) right--;
            else left++;
        }

        return new int[]{-1};
    }
}
