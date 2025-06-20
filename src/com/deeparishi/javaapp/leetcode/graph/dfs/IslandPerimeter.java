package com.deeparishi.javaapp.leetcode.graph.dfs;

// https://leetcode.com/problems/island-perimeter/

public class IslandPerimeter {

    public static void main(String[] args) {
        
    }

    public int islandPerimeter(int[][] grid) {

        int per = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(grid[i][j] == 1) {
                    return dfs(grid, i, j, rowLen, colLen);
                }
            }
        }

        return per;
    }

    private int dfs(int[][] grid, int row, int col, int rowLen, int colLen) {

        if(row < 0 || row >= rowLen || col < 0 || col >= colLen || grid[row][col] == 0)
            return 1;

        if (grid[row][col] == -1)
            return 0;

        grid[row][col] = -1;

        int area = 0;

        area += dfs(grid, row - 1, col, rowLen, colLen); // left
        area += dfs(grid, row + 1, col, rowLen, colLen); // right
        area += dfs(grid, row, col + 1, rowLen, colLen);
        area += dfs(grid, row, col - 1, rowLen, colLen);

        return area;
    }

}
