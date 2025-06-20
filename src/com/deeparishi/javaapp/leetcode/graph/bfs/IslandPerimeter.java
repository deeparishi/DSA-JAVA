package com.deeparishi.javaapp.leetcode.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/island-perimeter/

public class IslandPerimeter {

    public static void main(String[] args) {
        
    }

    public int islandPerimeter(int[][] grid) {

        int rowLen = grid.length;
        int colLen = grid[0].length;
        int p = 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rowLen][colLen];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    break;
                }
            }
            if(!queue.isEmpty()) break;
        }

        int[][] directions = {
                {-1, 0},//UP
                {1, 0},//Down
                {0, -1},//left
                {0, 1}//right
        };



        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int row = polled[0];
            int col = polled[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (!isValid(newRow, newCol, rowLen, colLen) ||  grid[newRow][newCol] == 0)
                    p++;
                else if(grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return p;
    }

    private static boolean isValid(int newRow, int newCol, int rowLen, int colLen) {
        return newRow >= 0 && newCol >= 0 && newRow < rowLen && newCol < colLen;
    }
}
