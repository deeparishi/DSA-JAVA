package com.deeparishi.javaapp.leetcode.slidingwindow;

public class PossibleSumPair {

    public static void main(String[] args) {
        System.out.println(possibility(new int[]{1, 2, 3}, 3));
    }

    public static int possibility(int[] arr, int target) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int possibility = 0;

        while (right < arr.length) {
            sum += arr[right++];

            while (sum > target && left < right)
                sum -= arr[left++];

            if (sum == target) {
                possibility++;
                sum -= arr[left++];
            }
        }

        return possibility;
    }
}
