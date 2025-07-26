package com.deeparishi.javaapp.leetcode.sorting;

public class SortedRotatedArray {

    public static void main(String[] args) {
        SortedRotatedArray checker = new SortedRotatedArray();

        System.out.println(checker.check(new int[]{3, 4, 5, 1, 2})); // true
        System.out.println(checker.check(new int[]{2, 1, 3, 4}));    // false
        System.out.println(checker.check(new int[]{1, 2, 3}));       // true
        System.out.println(checker.check(new int[]{1, 1, 1}));
    }

    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            if (nums[i] > nums[next]) {
                count++;
            }

            if (count > 1)
                return false;
        }

        return true;
    }

}
