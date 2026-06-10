package com.deeparishi.javaapp.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

// https://leetcode.com/problems/avoid-flood-in-the-city/description/?envType=problem-list-v2&envId=hash-table

public class AvoidFlood {

    public static void main(String[] args) {
        int[] results = avoidFlood(new int[]{1, 2, 0, 0, 2, 1});
    }

    public static int[] avoidFlood(int[] rains) {

        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1;
            } else {
                int lake = rains[i];
                ans[i] = -1;
                if (lastRain.containsKey(lake)) {
                    int prevRainDay = lastRain.get(lake);
                    Integer dryDay = dryDays.higher(prevRainDay);
                    if (dryDay == null)
                        return new int[0];
                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                lastRain.put(lake, i);
            }
        }
        return ans;
    }
}
