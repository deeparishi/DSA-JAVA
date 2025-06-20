package com.deeparishi.javaapp.leetcode.graph.dfs;

// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid

public class FindMaxNoFishInGrid {

    public static void main(String[] args) {

        int[][] grid1 = {
                {0, 2, 1, 0},
                {4, 0, 0, 3},
                {1, 0, 0, 4},
                {0, 3, 2, 0}
        };

        int[][] grid2 = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        };

        int[][] grid3 = {
                {6, 1, 10}
        };


        System.out.println(findMaxFish(grid1));
        System.out.println(findMaxFish(grid2));
        System.out.println(findMaxFish(grid3));

    }

    public static int findMaxFish(int[][] grid) {

        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] isVisited = new boolean[rowLen][colLen];

        int max = 0;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (!isVisited[row][col] && grid[row][col] > 0)
                    max = Math.max(max, dfs(grid, isVisited, row, col, rowLen, colLen));
            }
        }

        return max;
    }

    private static int dfs(int[][] grid, boolean[][] isVisited, int row, int col, int rowLen, int colLen) {

        if (row < 0 || col < 0 || row >= rowLen || col >= colLen)
            return 0;

        if(isVisited[row][col] || grid[row][col] == 0)
            return 0;

        isVisited[row][col] = true;

        int total = grid[row][col];

        total += dfs(grid, isVisited, row, col - 1, rowLen, colLen);
        total += dfs(grid, isVisited, row, col + 1, rowLen, colLen);
        total += dfs(grid, isVisited, row - 1, col, rowLen, colLen);
        total += dfs(grid, isVisited, row + 1, col, rowLen, colLen);

        return total;
    }
}
