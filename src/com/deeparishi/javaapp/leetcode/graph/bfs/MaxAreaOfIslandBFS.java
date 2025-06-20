package com.deeparishi.javaapp.leetcode.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/max-area-of-island

public class MaxAreaOfIslandBFS {

    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

    }

    public int maxAreaOfIsland(int[][] grid) {

        int rowLen = grid.length;
        int colLen = grid[0].length;
        int maxArea = Integer.MIN_VALUE;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == 1) {
                    int area = bfs(grid, row, col, rowLen, colLen);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int bfs(int[][] grid, int row, int col, int rowLen, int colLen) {

        int area = 1;
        int[][] directions = {
                {-1, 0},//UP
                {1, 0},//Down
                {0, -1},//left
                {0, 1}//right
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = 0;

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int currRow = polled[0];
            int currCol = polled[1];

            for (int[] direction : directions) {
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];
                if (isValid(newRow, newCol, rowLen, colLen) && grid[newRow][newCol] == 1) {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 0;
                    area++;
                }
            }
        }

        return area;
    }

    private static boolean isValid(int newRow, int newCol, int rowLen, int colLen) {
        return newRow >= 0 && newCol >= 0 && newRow < rowLen && newCol < colLen;
    }
}
