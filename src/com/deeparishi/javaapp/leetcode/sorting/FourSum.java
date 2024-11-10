package com.deeparishi.javaapp.leetcode.sorting;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {

        System.out.println(fourSumBetter(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(fourSumBetter(new int[]{2, 2, 2, 2, 2}, 8));
    }

    static List<List<Integer>> fourSumBetter(int[] nums, int target) {

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int data = target - sum;
                    if(map.containsKey(data)){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        result.add(list);
                    }
                    map.put(nums[k], k);
                }
            }
        }

        return new ArrayList<>(result);
    }

        // Brute Force Approach
    static List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(list);
                            result.add(list);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
