package com.deeparishi.javaapp.leetcode.graph.stronglyconnectedcomponents;

// https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/description/

public class MinNoOfDaysToDisconnectIsland {

    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        System.out.println(minDays(grid));
    }

    public static int minDays(int[][] grid) {

        if (isConnected(grid)) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (isConnected(grid)) return 1;
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    private static boolean isConnected(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int startRow = -1, startCol = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
            if (startRow != -1) break;
        }

        if (startRow == -1) return true;

        int landCount = 0, totalLand = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) totalLand++;
            }
        }

        // Perform DFS
        dfs(grid, visited, startRow, startCol);

        for (boolean[] row : visited) {
            for (boolean cell : row) {
                if (cell) landCount++;
            }
        }

        return landCount != totalLand;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int row, int col) {

        int rows = grid.length, cols = grid[0].length;
        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || grid[row][col] == 0)
            return;

        visited[row][col] = true;

        dfs(grid, visited, row + 1, col);
        dfs(grid, visited, row - 1, col);
        dfs(grid, visited, row, col + 1);
        dfs(grid, visited, row, col - 1);
    }
}
