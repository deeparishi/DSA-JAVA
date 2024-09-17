package com.deeparishi.javaapp.leetcode;

public class AndSubArray {

    public static void main(String[] args) {

        int [] arr = new int[]{1,2,3,3,2,2};
        int [] arr2 = new int[]{1,2,3,4};
        System.out.println(longestSubArray(arr2));
    }

    public static int longestSubArray(int[] nums) {

        int result= 0;

        for (int i=0; i<nums.length-2; i++){
            int check = nums[i] & nums[i+1];
            if(check > result)
                result = check;
        }

        return result-1;
    }
}
