package com.deeparishi.javaapp.leetcode.sorting;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    // BruteForce Approach
    static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> resultSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        resultSet.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(resultSet);
    }
}
