package com.deeparishi.javaapp.leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortEvenOdd {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortEvenOdd(new int[]{4, 1, 2, 3})));
    }

    public static int[] sortEvenOdd(int[] nums) {

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) even.add(nums[i]);
            else odd.add(nums[i]);
        }

        Collections.sort(even);
        odd.sort(Collections.reverseOrder());

        int o = 0, e = 0;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) res[i] = even.get(e++);
            else res[i] = odd.get(o++);
        }

        return res;
    }
}
