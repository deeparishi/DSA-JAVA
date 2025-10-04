package com.deeparishi.javaapp.leetcode.arrays;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DisappearedNumbers {

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDisappearedNumbers(new int[]{1, 1}));
    }

    public static List<Integer> findDisappearedNum(int[] arr) {
        Set<Integer> lookup = new LinkedHashSet<>();
        for (int j : arr) {
            lookup.add(j);
        }

        List<Integer> missing = new ArrayList<>();
        for (int i = 1; i <= arr.length; i++) {
            if (!lookup.contains(i))
                missing.add(i);
        }

        return missing;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
