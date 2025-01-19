package com.deeparishi.javaapp.leetcode.greedyalgo;

import java.util.Arrays;

// https://leetcode.com/problems/non-overlapping-intervals/

public class NonOverlappingIntervals {

    public static void main(String[] args) {

    }

    public int eraseOverlapIntervals(int[][] meetings) {

        Arrays.sort(meetings, (arr1, arr2) -> arr1[1] - arr2[1]);
        int count = 1;
        int lastEndTime = meetings[0][1];
        int len = meetings.length;

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] >= lastEndTime) {
                count++;
                lastEndTime = meetings[i][1];
            }
        }

        return len - count;
    }
}
