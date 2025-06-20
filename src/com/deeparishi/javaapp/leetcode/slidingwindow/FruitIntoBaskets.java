package com.deeparishi.javaapp.leetcode.slidingwindow;

// https://leetcode.com/problems/fruit-into-baskets

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitIntoBaskets {

    public static void main(String[] args) {

        int[] a = {1, 2, 1};
        int[] b = {0, 1, 2, 2};
        int[] c = {1, 2, 3, 2, 2};

        System.out.println(totalFruitV4(a));
        System.out.println(totalFruitV4(b));
        System.out.println(totalFruitV4(c));
    }

    // O(N) Solution Hence Optimal Approach
    public static int totalFruitV3(int[] fruits) {

        int max = 0;
        int right = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < fruits.length) {

            int val = fruits[right];
            map.put(val, map.getOrDefault(val, 0) + 1);

            while (map.size() > 2) {
                int leftVal = fruits[left];
                map.put(leftVal, map.getOrDefault(fruits[left], 0) - 1);
                if (map.get(leftVal) == 0) map.remove(leftVal);
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }

    // Implemented array instead of map
    public static int totalFruitV4(int[] fruits) {

        int left = 0;
        int right = 0;
        int[] fruitFreq = new int[100001];
        int n = fruits.length;
        int max = 0;
        int fruitTypes = 0;

        while (right < n) {

            int rightVal = fruits[right];

            while (fruitTypes > 2) {
                int leftVal = fruits[left];
                fruitFreq[leftVal]--;
                if (fruitFreq[leftVal] == 0) fruitTypes--;
                left++;
            }

            fruitFreq[rightVal]++;
            if (fruitFreq[rightVal] == 1) fruitTypes++;
            if (fruitTypes <= 2) max = Math.max(max, right - left + 1);

            right++;
        }
        return max;
    }

    // Better Approach
    public static int totalFruitV2(int[] fruits) {

        int max = 0;
        int right = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < fruits.length) {

            int val = fruits[right];
            map.put(val, map.getOrDefault(val, 0) + 1);

            while (map.size() > 2) {
                int leftVal = fruits[left];
                map.put(leftVal, map.getOrDefault(fruits[left], 0) - 1);
                if (map.get(leftVal) == 0) map.remove(leftVal);
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }

    // Brute Force Approach
    public static int totalFruitV1(int[] fruits) {

        int max = 0;
        int len = fruits.length;

        for (int i = 0; i < len; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < len; j++) {
                set.add(fruits[j]);
                if (set.size() <= 2)
                    max = Math.max(max, j - i + 1);
                else
                    break;
            }
        }
        return max;
    }

}