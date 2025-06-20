package com.deeparishi.javaapp.leetcode.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid

public class MaxNoOfFishInGrid {

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
        int max = 0;
        boolean[][] visited = new boolean[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (!visited[i][j] && grid[i][j] > 0)
                    max = Math.max(max, bfs(grid, visited, i, j, rowLen, colLen));
            }
        }

        return max;
    }

    public static int bfs(int[][] grid, boolean[][] visited, int row, int col, int rowLen, int colLen) {

        int[][] directions = {
                {-1, 0},//UP
                {1, 0},//Down
                {0, -1},//left
                {0, 1}//right
        };


        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int totalFish = 0;
        visited[row][col] = true;

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            totalFish += grid[currRow][currCol];

            for (int[] direction : directions) {
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];

                if (isValid(newRow, newCol, rowLen, colLen) && !visited[newRow][newCol] && grid[newRow][newCol] > 0) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return totalFish;
    }

    private static boolean isValid(int newRow, int newCol, int rowLen, int colLen) {
        return newRow >= 0 && newCol >= 0 && newRow < rowLen && newCol < colLen;
    }
}
