package com.deeparishi.javaapp.leetcode.recursion;

// https://leetcode.com/problems/house-robber

public class HouseRobberI {

    public static void main(String[] args) {

        int[] x = {1,2,3,1};
        int[] y = {2,7,9,3,1};

        System.out.println(rob(x));
        System.out.println(rob(y));
    }

    public static int rob(int[] houseNetWorth) {
        return rob(houseNetWorth, 0);
    }

    private static int rob(int[] houseNetWorth, int currIdx) {

        if (currIdx >= houseNetWorth.length) return 0;

        int stealFirstHouse = houseNetWorth[currIdx] + rob(houseNetWorth, currIdx + 2);
        int skipFirstHouse = rob(houseNetWorth, currIdx + 1);

        return Math.max(stealFirstHouse, skipFirstHouse);
    }
}
