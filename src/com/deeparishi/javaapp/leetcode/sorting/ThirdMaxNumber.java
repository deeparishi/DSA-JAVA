package com.deeparishi.javaapp.leetcode.sorting;

import java.util.HashSet;
import java.util.Set;

public class ThirdMaxNumber {

    public static void main(String[] args) {

//        System.out.println(thirdMax(new int[]{2,2,3,1})); // 1
//        System.out.println(thirdMax(new int[]{3,2,1}));   //1
//        System.out.println(thirdMax(new int[]{1, 2}));    //2
        System.out.println(thirdMax(new int[]{1,2,-2147483648}));    //-2147483648

    }

    static int thirdMax(int[] nums) {

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        Set<Integer> seen = new HashSet<>();
        int i = 0;

        while (i < nums.length) {

            if (nums[i] > firstMax && !seen.contains(nums[i])) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
                seen.add(nums[i]);
            } else if (nums[i] > secondMax && !seen.contains(nums[i])) {
                thirdMax = secondMax;
                secondMax = nums[i];
                seen.add(nums[i]);
            } else if (nums[i] >= thirdMax && !seen.contains(nums[i])) {
                thirdMax = nums[i];
                seen.add(nums[i]);
            }
            i++;
        }

        if (seen.size() < 3) {
            return firstMax;
        }

        return thirdMax;

    }
}
