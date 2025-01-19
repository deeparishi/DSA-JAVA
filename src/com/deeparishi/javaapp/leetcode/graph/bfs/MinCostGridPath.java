package com.deeparishi.javaapp.leetcode.graph.bfs;

import java.util.*;

public class MinCostGridPath {

    public static void main(String[] args) {

        // Test case
        int[][] grid = {
                {1, 1, 3},
                {3, 2, 2},
                {1, 1, 4}
        };

        System.out.println(minCostV1(grid));
        System.out.println(minCostV2(grid));
    }


    // Brute Force Approach
    public static int minCostV1(int[][] grid) {

        int rowLen = grid.length;
        int colLen = grid[0].length;

        int[][] directions = {
                {0, 1},  // Right
                {0, -1}, // Left
                {1, 0},  // Down
                {-1, 0}  // Up
        };

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[]{0, 0, 0});

        boolean[][] visited = new boolean[rowLen][colLen];

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int cost = current[0];
            int row = current[1];
            int col = current[2];

            if (row == rowLen - 1 && col == colLen - 1) return cost;

            if (visited[row][col]) continue;
            visited[row][col] = true;

            for (int i = 0; i < 4; i++) {

                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];

                if (isValid(newRow, newCol, rowLen, colLen)) {
                    if (i + 1 == grid[row][col])
                        queue.add(new int[]{cost, newRow, newCol});
                    else
                        queue.add(new int[]{cost + 1, newRow, newCol});
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int newRow, int newCol, int rowLen, int colLen) {
        return newRow >= 0 && newCol >= 0 && newRow < rowLen && newCol < colLen;
    }

    // // Optimal Approach
    public static int minCostV2(int[][] grid) {

        int rowLen = grid.length;
        int colLen = grid[0].length;

        int[][] directions = {
                {0, 1}, // Right
                {0, -1}, // Left
                {1, 0}, // Down
                {-1, 0} // Up
        };

        // Priority queue for BFS (0-1 BFS)
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0, 0});

        boolean[][] visited = new boolean[rowLen][colLen];

        while (!deque.isEmpty()) {

            int[] current = deque.poll();
            int row = current[0];
            int col = current[1];
            int cost = current[2];

            if (row == rowLen - 1 && col == colLen - 1) return cost;
            if (visited[row][col]) continue;

            visited[row][col] = true;

            for (int i = 0; i < 4; i++) {

                int newRow = row + directions[i][0];
                int newCol = col + directions[i][1];

                if (newRow >= 0 && newCol >= 0 && newRow < rowLen && newCol < colLen) {
                    if (i + 1 == grid[row][col])
                        deque.addFirst(new int[]{newRow, newCol, cost}); // Cost 0
                    else
                        deque.addLast(new int[]{newRow, newCol, cost + 1}); // Cost 1
                }
            }
        }

        return -1;
    }
}