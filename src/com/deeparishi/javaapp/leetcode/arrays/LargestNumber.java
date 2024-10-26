package com.deeparishi.javaapp.leetcode.arrays;

import java.util.Arrays;

public class LargestNumber {

    // https://leetcode.com/problems/largest-number

    public static void main(String[] args) {

        System.out.println(largestNumber(new int[]{3, 60, 34, 5, 9}));

//        String[] arr = new String[]{"9","60","3","34","5"};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

    }

    public static String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b) );

        StringBuilder builder = new StringBuilder();

       for (String res : arr)
           builder.append(res);

       return builder.toString();
    }
}
