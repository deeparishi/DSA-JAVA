package com.deeparishi.javaapp.leetcode.greedyalgo;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

public class MinNoOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        int[][] pos = {
                {-2147483646, -2147483645},
                {2147483646, 2147483647}
        };

        System.out.println(findMinArrowShots(pos));
    }

    public static int findMinArrowShots(int[][] positions) {

        Arrays.sort(positions, Comparator.comparingInt(a -> a[1]));

        int min = 1;
        int pos = positions[0][1];

        for (int i = 1; i < positions.length; i++) {
            if(positions[i][0] > pos) {
                min++;
                pos = positions[i][1];
            }
        }

        return min;

    }
}
