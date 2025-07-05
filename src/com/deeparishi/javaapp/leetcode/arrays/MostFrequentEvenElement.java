package com.deeparishi.javaapp.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/most-frequent-even-element/

public class MostFrequentEvenElement {

    public static void main(String[] args) {

    }

    public static int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> lookup = new HashMap<>();

        for (int n : nums) {
            if (n % 2 == 0)
                lookup.put(n, lookup.getOrDefault(n, 0) + 1);
        }

        if(lookup.isEmpty())
            return -1;

        int val = Integer.MAX_VALUE;
        int appeared = 0;
        for (Map.Entry<Integer, Integer> entry : lookup.entrySet()) {
            int v = entry.getKey();
            int count = entry.getValue();
            if (count > appeared || (count == appeared && v < val)) {
                val = v;
                appeared = count;
            }
        }

        return val;
    }
}
