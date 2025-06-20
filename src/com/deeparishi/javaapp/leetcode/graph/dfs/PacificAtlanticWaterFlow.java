package com.deeparishi.javaapp.leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/pacific-atlantic-water-flow


public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {

        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        System.out.println(pacificAtlanticBFS(heights));
    }

    public static List<List<Integer>> pacificAtlanticDFS(int[][] heights) {

        List<List<Integer>> res = new ArrayList<>();

        if (heights.length == 0)
            return res;

        int rowLen = heights.length;
        int colLen = heights[0].length;

        boolean[][] atlantic = new boolean[rowLen][colLen];
        boolean[][] pacific = new boolean[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, atlantic, i, colLen - 1, Integer.MIN_VALUE);
        }

        for (int i = 0; i < colLen; i++) {
            dfs(heights, pacific, 0, i, Integer.MIN_VALUE); // Top
            dfs(heights, atlantic, rowLen - 1, i, Integer.MIN_VALUE); // Bottom
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(List.of(i, j));
            }
        }

        return res;
    }

    public static void dfs(int[][] heights, boolean[][] ocean, int row, int col, int prev) {

        if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length
                || heights[row][col] < prev || ocean[row][col])
            return;

        ocean[row][col] = true;

        dfs(heights, ocean, row, col - 1, heights[row][col]); // Left
        dfs(heights, ocean, row, col + 1, heights[row][col]); // Right
        dfs(heights, ocean, row - 1, col, heights[row][col]); // Up
        dfs(heights, ocean, row + 1, col, heights[row][col]); // Down
    }

    public static List<List<Integer>> pacificAtlanticBFS(int[][] heights) {

        List<List<Integer>> res = new ArrayList<>();

        if(heights.length == 0)
            return res;

        int rowLen = heights.length;
        int colLen = heights[0].length;

        boolean[][] atlantic = new boolean[rowLen][colLen];
        boolean[][] pacific = new boolean[rowLen][colLen];

        Queue<int[]> atlanticQueue = new LinkedList<>();
        Queue<int[]> pacificQueue = new LinkedList<>();

        for (int i = 0; i < rowLen; i++) {
            pacificQueue.offer(new int[]{i, 0});
            atlanticQueue.offer(new int[]{i, colLen - 1});
            pacific[i][0] = true;
            atlantic[i][colLen - 1] = true;
        }

        for (int i = 0; i < colLen; i++) {
            pacificQueue.offer(new int[]{0, i});
            atlanticQueue.offer(new int[]{rowLen - 1, i});
            pacific[0][i] = true;
            atlantic[rowLen - 1][i] = true;
        }


        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(List.of(i, j));
            }
        }


        return res;
    }


    public static void bfs(int[][] heights, Queue<int[]> oceanQueue, boolean[][] visited)   {

        int[][] directions = {
                {-1, 0},//UP
                {1, 0},//Down
                {0, -1},//left
                {0, 1}//right
        };

        while (!oceanQueue.isEmpty()) {
            int[] ocean = oceanQueue.poll();
            int x = ocean[0];
            int y = ocean[1];

            for (int[] direction : directions) {

                int newRow = x + direction[0];
                int newCol = y + direction[1];

                if (isValid(newRow, newCol, heights.length, heights[0].length) && !visited[newRow][newCol] &&
                        heights[newRow][newCol] >= heights[x][y]) {
                    visited[newRow][newCol] = true;
                    oceanQueue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    private static boolean isValid(int newRow, int newCol, int rowLen, int colLen) {
        return newRow >= 0 && newCol >= 0 && newRow < rowLen && newCol < colLen;
    }

}