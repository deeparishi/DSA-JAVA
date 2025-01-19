package com.deeparishi.javaapp.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDiffInTwoArrays {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3};
        int[] num2 = {2, 4, 6};
        System.out.println(findDifference(num1, num2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> x = new HashSet<>();
        Set<Integer> y = new HashSet<>();

        for (int num : nums1) x.add(num);
        for (int num : nums2) y.add(num);

        for (int num : nums2) {
            if (x.contains(num)) {
                x.remove(num);
                y.remove(num);
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>(x));
        res.add(new ArrayList<>(y));
        return res;
    }
}
