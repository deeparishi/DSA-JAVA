package com.deeparishi.javaapp.leetcode.prefixsum;

import java.util.*;

// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

public class MinNoOfOperationToMoveAllBalls {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(minOperations("110")));
    }

    // Brute Force
    public static int[] minOperations(String boxes) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> idx = new ArrayList<>();

        for (int i = 0; i < boxes.length(); i++) {
            int v = Character.getNumericValue(boxes.charAt(i));
            map.put(i, v);
            if (v == 1) idx.add(i);
        }

        int[] res = new int[boxes.length()];

        for (int i = 0; i < map.size(); i++) {
            int count = 0;
            for (Integer a : idx)
                count += Math.abs(i - a);
            res[i] = count;
        }

        return res;
    }

    // Optimal Approach
    public static int[] minOperationsV2(String boxes) {

        int n = boxes.length();
        int[] res = new int[n];

        int count = 0;
        int operations = 0;

        // Left to Right Move
        for (int i = 0; i < n; i++) {
            res[i] = operations;
            count += boxes.charAt(i) - '0';
            operations += count;
        }

        count = 0;
        operations = 0;

        for (int i = n - 1; i >= 0; i--) {
            res[i] += operations;
            count += Character.getNumericValue(boxes.charAt(i));
            operations += count;
        }

        return res;
    }
}