package com.deeparishi.javaapp.leetcode.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //https://leetcode.com/problems/two-sum/

    public static void main(String[] args) {

        int[] arr = new int[]{-3, 4, 3, 90};
        int[] res = twoSumBetter(arr, 0);
        System.out.println(Arrays.toString(res));
        System.out.println(twoSumOptimal(arr, 0));

    }

    //Optimal Approach for variety two i.e true/false instead of indx, go with below approach
    static boolean twoSumOptimal(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        Arrays.sort(nums);

        while (left < right){
            int res = nums[left] + nums[right];
            if(res == target) return true;
            else if (res < target) left++;
            else right--;
        }

        return false;
    }

    //Better Approach
    static int[] twoSumBetter(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int data = target - val;
            if (map.get(data) != null) {
                return new int[]{map.get(data), i};
            }
            map.put(val, i);
        }

        return new int[]{};
    }

    //Brute Force Approach
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}