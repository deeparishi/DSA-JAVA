package com.deeparishi.javaapp.leetcode.arrays;

// https://leetcode.com/problems/grid-game

public class GridGame {

    public static void main(String[] args) {

        int[][] grid1 = {
                {2, 5, 4},
                {1, 5, 1}
        };

        int[][] grid2 = {
                {3, 3, 1},
                {8, 5, 2}
        };

        int[][] grid3 = {
                {1, 3, 1,15},
                {1,3,3,1}
        };

        System.out.println(gridGameV1(grid1)); //4
        System.out.println(gridGameV1(grid2)); //4
        System.out.println(gridGameV1(grid3)); //7

        System.out.println();

        System.out.println(gridGameV2(grid1));
        System.out.println(gridGameV2(grid2));
        System.out.println(gridGameV2(grid3));
    }

    public static long gridGameV1(int[][] grid) {

        int n = grid[0].length;
        long[] prefixTop = new long[n];
        long[] prefixBottom = new long[n];

        prefixTop[0] = grid[0][0];
        prefixBottom[0] = grid[1][0];

        for (int i = 1; i < n; i++) {
            prefixTop[i] = prefixTop[i - 1] + grid[0][i];
            prefixBottom[i] = prefixBottom[i - 1] + grid[1][i];
        }

        long result = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long topPath = (i == n - 1) ? 0 : prefixTop[n - 1] - prefixTop[i];
            long bottomPath = (i == 0) ? 0 : prefixBottom[i - 1];
            long secondRobotScore = Math.max(topPath, bottomPath);
            result = Math.min(result, secondRobotScore);
        }

        return result;
    }

    public static long gridGameV2(int[][] grid) {

        long ans = Long.MAX_VALUE;
        long s1 = 0; //suffix sum of the points in the first row
        long s2 = 0; //prefix sum of the points in the second row

        for (int v : grid[0])
            s1 += v;

        int n = grid[0].length;

        for (int j = 0; j < n; ++j) { //j = find optimal position to go down
            s1 -= grid[0][j];
            ans = Math.min(ans, Math.max(s1, s2));
            s2 += grid[1][j];
        }

        return ans;
    }
}
