package com.deeparishi.javaapp.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/

public class PrefixCommonArrayOfTwoArray {

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 4};
        int[] b = {3, 1, 2, 4};

        System.out.println(Arrays.toString(findThePrefixCommonArrayV2(a, b)));
    }

    public static int[] findThePrefixCommonArray(int[] a, int[] b) {

        int[] c = new int[a.length];
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            int x = a[i];
            int y = b[i];

            if (set.contains(x))
                count++;
            else set.add(x);

            if (set.contains(y))
                count++;
            else set.add(y);

            c[i] = count;
        }

        return c;
    }

    public static int[] findThePrefixCommonArrayV2(int[] a, int[] b) {

        int[] c = new int[a.length];
        int[] arr = new int[a.length + 1];
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            if (++arr[a[i]] == 2) count++;
            if (++arr[b[i]] == 2) count++;
            c[i] = count;
        }


        return c;
    }
}
