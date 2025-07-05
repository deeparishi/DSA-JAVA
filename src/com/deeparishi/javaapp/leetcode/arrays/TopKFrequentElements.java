package com.deeparishi.javaapp.leetcode.arrays;

// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public static void main(String[] args) {

    }

    public int[] topKFrequentBrute(int[] num, int k) {

        Map<Integer, Integer> lookup = new HashMap<>();

        for (int n : num)
            lookup.put(n, lookup.getOrDefault(n, 1) + 1);

        int[] topMost = new int[k];

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(lookup.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < k; i++) {
            topMost[i] = entries.get(i).getKey();
        }

        return topMost;
    }
}