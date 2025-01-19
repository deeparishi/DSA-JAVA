package com.deeparishi.javaapp.leetcode.graph.disjointset;

import com.deeparishi.javaapp.leetcode.graph.disjointset.utils.DisjointSet;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-consecutive-sequence/submissions/1496153890/?envType=study-plan-v2&envId=top-interview-150


public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Map<Integer, Integer> numToIndex = new HashMap<>();
        int n = nums.length;
        DisjointSet ds = new DisjointSet(n);

        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        for (int num : nums) {
            if (numToIndex.containsKey(num - 1)) {
                ds.unionBySize(numToIndex.get(num), numToIndex.get(num - 1));
            }
        }

        int longest = 0;
        for (int i = 0; i < n; i++) {
            longest = Math.max(longest, ds.getSize(i));
        }

        return longest;

    }
}
