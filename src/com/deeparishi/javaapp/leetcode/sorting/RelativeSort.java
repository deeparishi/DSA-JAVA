package com.deeparishi.javaapp.leetcode.sorting;

import java.util.HashMap;
import java.util.Map;

public class RelativeSort {

    public static void main(String[] args) {

        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        int[] rs = relativeSortArray(arr1, arr2);
    }

    static int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            for (int k : arr1) {
                if (arr2[i] == k) {
                    map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
                }
            }
        }

        for (Integer v : map.values()) {
            for (int i = 0; i < result.length; i++) {

            }
        }


        return result;
    }
}
