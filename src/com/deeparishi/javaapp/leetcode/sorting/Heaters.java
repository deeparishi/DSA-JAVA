package com.deeparishi.javaapp.leetcode.sorting;

import java.util.Arrays;

public class Heaters {

    //https://leetcode.com/problems/heaters/?envType=problem-list-v2&envId=sorting&difficulty=MEDIUM

    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1,2,3,4}, new int[]{1, 4}));
    }

    static int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int radius = 0;
        int i = 0;
        int left, right;

        for (int house : houses){
            while (house < heaters.length && heaters[i] <= house)
                i++;
            left = Math.abs(house -  (i > 0 ? heaters[i - 1] : heaters[0]));
            right = Math.abs(heaters[i] - house);

            radius = Math.max(radius, Math.min(left, right));
        }

        return radius;
    }
}

