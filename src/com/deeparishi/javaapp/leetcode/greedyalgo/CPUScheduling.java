package com.deeparishi.javaapp.leetcode.greedyalgo;

import java.util.Arrays;

public class CPUScheduling {

    public static void main(String[] args) {

        int[] bt = new int[]{4, 3, 7, 1, 2};
        System.out.println(solve(bt));
    }

    public static int solve(int[] bt) {

        Arrays.sort(bt);

        int time = 0;
        int waitingTime = 0;

        for (int j : bt) {
            waitingTime += time;
            time += j;
        }

        return waitingTime / bt.length;
    }
}
