package com.deeparishi.javaapp.leetcode.graph.bfs;

import java.util.PriorityQueue;

// https://leetcode.com/problems/trapping-rain-water-ii

public class TrappingRainWaterII {

    public static void main(String[] args) {

        int[][] grid1 = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };

        int[][] grid2 = {
                {3, 3, 3, 3, 3},
                {3, 2, 2, 2, 3},
                {3, 2, 1, 2, 3},
                {3, 2, 2, 2, 3},
                {3, 3, 3, 3, 3}
        };

        System.out.println(trapRainWater(grid1));
        System.out.println(trapRainWater(grid2));

    }

    public static int trapRainWater(int[][] heightMap) {

        int rowLen = heightMap.length;
        int colLen = heightMap[0].length;

        if (rowLen < 3 || colLen < 3) return 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[rowLen][colLen];

        int[][] directions = {
                {0, 1}, // Right
                {0, -1}, // Left
                {1, 0}, // Down
                {-1, 0} // Up
        };


//        for (int i = 0; i < rowLen; i++) {
//            for (int j = 0; j < colLen; j++) {
//                if (i == 0 || i == rowLen - 1 || j == 0 || j == colLen - 1) {
//                    minHeap.add(new int[]{heightMap[i][j], i, j});
//                    visited[i][j] = true;
//                }
//            }
//        }

        for (int i = 0; i < rowLen; i++) {
            // Add leftmost and rightmost columns for each row
            minHeap.add(new int[]{heightMap[i][0], i, 0});
            minHeap.add(new int[]{heightMap[i][colLen - 1], i, colLen - 1});
            visited[i][0] = true;
            visited[i][colLen - 1] = true;
        }

        for (int j = 0; j < colLen; j++) {
            // Add topmost and bottommost rows for each column
            minHeap.add(new int[]{heightMap[0][j], 0, j});
            minHeap.add(new int[]{heightMap[rowLen - 1][j], rowLen - 1, j});
            visited[0][j] = true;
            visited[rowLen - 1][j] = true;
        }

        int trappedWater = 0;
        int level = 0;

        while (!minHeap.isEmpty()) {

            int[] polled = minHeap.poll();
            int height = polled[0];
            int row = polled[1];
            int col = polled[2];

            level = Math.max(level, height);

            for (int i = 0; i < 4; i++) {
                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];
                if (isValid(newRow, newCol, rowLen, colLen) && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    minHeap.add(new int[]{heightMap[newRow][newCol], newRow, newCol});
                    if (heightMap[newRow][newCol] < level)
                        trappedWater += level - heightMap[newRow][newCol];
                }
            }
        }

        return trappedWater;
    }

    private static boolean isValid(int newRow, int newCol, int rowLen, int colLen) {
        return newRow >= 0 && newCol >= 0 && newRow < rowLen && newCol < colLen;
    }
}