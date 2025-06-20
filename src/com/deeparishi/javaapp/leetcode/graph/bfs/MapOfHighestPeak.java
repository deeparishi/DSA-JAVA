package com.deeparishi.javaapp.leetcode.graph.bfs;

// https://leetcode.com/problems/map-of-highest-peak

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {

    public static void main(String[] args) {

        int[][] grid1 = {
                {0, 1},
                {0, 0}
        };

        int[][] grid2 = {
                {0, 0, 1},
                {1, 0, 0},
                {0, 0, 0}
        };

        System.out.println(Arrays.deepToString(highestPeak(grid1)));
        System.out.println(Arrays.deepToString(highestPeak(grid2)));
    }

    // 0 - Land, 1 - Water
    public static int[][] highestPeak(int[][] isWater) {

        int rowLen = isWater.length;
        int colLen = isWater[0].length;

        int[][] res = new int[rowLen][colLen];
        Queue<int[]> queue = new LinkedList<>();

        // Find the water areas add it to queue
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (isWater[row][col] == 1) {
                    queue.add(new int[]{row, col});
                    res[row][col] = 0;
                } else
                    res[row][col] = -1;
            }
        }

        int[][] directions = {
                {0, 1}, // Right
                {0, -1}, // Left
                {1, 0}, // Down
                {-1, 0} // Up
        };


        // start from queue
        while (!queue.isEmpty()) {

            int[] polled = queue.poll();
            int row = polled[0];
            int col = polled[1];

            for (int i = 0; i < 4; i++) {
                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];
                if (isValid(newRow, newCol, rowLen, colLen) && res[newRow][newCol] == -1) {
                    res[newRow][newCol] = res[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return res;
    }

    private static boolean isValid(int newRow, int newCol, int rowLen, int colLen) {
        return newRow >= 0 && newCol >= 0 && newRow < rowLen && newCol < colLen;
    }
}
