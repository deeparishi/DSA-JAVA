package com.deeparishi.javaapp.leetcode.greedyalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/insert-interval

public class InsertIntervals {

    public static void main(String[] args) {

        int[][] interval = {
                {1, 3},
                {6, 9}
        };

        int[] newInterval = {2, 5};

        System.out.println(Arrays.deepToString(insert(interval, newInterval)));
    }

    // MEmory Optimized
    public static int[][] insertInterval(int[][] interval, int[] newInterval) {

        int len = interval.length;
        int[][] tempList = new int[len + 1][2];

        int i = 0;
        int index = 0;

        while (i < len && interval[i][1] < newInterval[0]) {
            tempList[index++] = interval[i++];
        }

        while (i < len && interval[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], interval[i][0]);
            newInterval[1] = Math.max(newInterval[1], interval[i][1]);
            i++;
        }
        tempList[index++] = newInterval;

        while (i < len) {
            tempList[index++] = interval[i++];
        }

        int[][] result = new int[index][2];
        System.arraycopy(tempList, 0, result, 0, index);

        return result;
    }

    // Final SOln
    public static int[][] insert(int[][] interval, int[] newInterval) {

        int len = interval.length;
        List<int[]> list = new ArrayList<>();

        int i = 0;

        while (i < len && interval[i][1] < newInterval[0]) {
            list.add(interval[i]);
            i++;
        }

        while (i < len && interval[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], interval[i][0]);
            newInterval[1] = Math.max(newInterval[1], interval[i][1]);
            i++;
        }


        list.add(newInterval);

        while (i < len) {
            list.add(interval[i]);
            i++;
        }

        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++)
            res[j] = list.get(j);

        return res;
    }
}
