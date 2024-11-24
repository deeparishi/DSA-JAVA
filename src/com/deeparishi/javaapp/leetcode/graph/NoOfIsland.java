package com.deeparishi.javaapp.leetcode.graph;


import com.deeparishi.javaapp.leetcode.graph.utls.Pair;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1?page=1&category=Graph&sortBy=submissions

public class NoOfIsland {

    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {

        int gridRow = grid.length;
        int gridCol = grid[0].length;

        boolean[][] visited = new boolean[gridRow][gridCol];
        int totalIsland = 0;

        for (int row = 0; row < gridRow; row++) {
            for (int col = 0; col < gridCol; col++) {
                if(!visited[row][col] && grid[row][col] == '1'){
                    totalIsland++;
                    dfs(row, col, visited, grid);
                }
            }
        }

        return totalIsland;
    }

    private void dfs(int row, int col, boolean[][] visited, char[][] grid) {
        visited[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> pairsQueue = new LinkedList<>();
        pairsQueue.add(new Pair(row, col));

        while (!pairsQueue.isEmpty()) {
            Pair pair = pairsQueue.poll();

            int newRow = pair.first;
            int newCol = pair.second;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nRow = newRow + i;
                    int nCol = newCol + j;
                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                            grid[nRow][nCol] == '1' && !visited[nRow][nCol]) {
                        visited[nRow][nCol] = true;
                        pairsQueue.add(new Pair(newRow, nCol));
                    }

                }
            }
        }
    }


    public int numIslandsWorkingSoln(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int totalIslands = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    totalIslands++;
                    dfs(grid, row, col, visited);
                }
            }
        }

        return totalIslands;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {

        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0' || visited[row][col])
            return;


        visited[row][col] = true;

        dfs(grid, row - 1, col, visited);     // Up
        dfs(grid, row + 1, col, visited);     // Down
        dfs(grid, row, col - 1, visited);     // Left
        dfs(grid, row, col + 1, visited);     // Right
        dfs(grid, row - 1, col - 1, visited); // Top-Left
        dfs(grid, row - 1, col + 1, visited); // Top-Right
        dfs(grid, row + 1, col - 1, visited); // Bottom-Left
        dfs(grid, row + 1, col + 1, visited); // Bottom-Right

    }
}
