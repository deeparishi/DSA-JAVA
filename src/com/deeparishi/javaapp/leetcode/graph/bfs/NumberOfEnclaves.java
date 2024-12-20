package com.deeparishi.javaapp.leetcode.graph.bfs;


//https://leetcode.com/problems/number-of-enclaves/


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public static void main(String[] args) {

    }

    public static int numEnclaves(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                    if (grid[i][j] == 1) {
                        queue.add(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
        }

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {

            int r = queue.peek()[0];
            int c = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];
                if (nRow >= 0 && nRow < row && nCol >= 0 && nCol < col
                        && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                    visited[nRow][nCol] = true;
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 1)
                    count++;
            }
        }

        return count;
    }
}
