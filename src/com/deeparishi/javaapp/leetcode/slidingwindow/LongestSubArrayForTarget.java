package com.deeparishi.javaapp.leetcode.slidingwindow;

import java.util.Arrays;

public class LongestSubArrayForTarget {

    public static void main(String[] args) {

        int[] arr = {2, 5, 1, 7, 10};
//        System.out.println(Arrays.toString(longestSubArrayV1(arr, 14)));
        System.out.println(Arrays.toString(longestSubArrayV2(arr, 14)));
    }

    // Brute Force Approach
    public static int[] longestSubArrayV1(int[] arr, int k) {

        int maxLength = 0;
        int startIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum <= k) {
                    if(j - i + 1 >= maxLength) {
                        maxLength = j - i + 1;
                        startIdx = i;
                    }
                } else break;
            }
        }

        int[] res = new int[maxLength];
        System.arraycopy(arr, startIdx, res, 0, maxLength);

        return res;
    }

    // Better Approach
    public static int[] longestSubArrayV2(int[] arr, int k) {

        int left = 0;
        int right = 0;
        int sum = 0;
        int maxSum = 0;
        int startIdx = 0;

        while (right < arr.length) {

            sum += arr[right];

            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            if (right - left + 1 >= maxSum) {
                maxSum = right - left + 1;
                startIdx = left;
            }

            right++;
        }

        System.out.println(maxSum);
        int[] res = new int[maxSum];
        System.arraycopy(arr, startIdx, res, 0, maxSum);
        return res;
    }
}
