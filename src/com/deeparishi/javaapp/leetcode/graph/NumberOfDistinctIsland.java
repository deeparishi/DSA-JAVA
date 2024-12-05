package com.deeparishi.javaapp.leetcode.graph;

import java.util.ArrayList;
import java.util.HashSet;

//https://leetcode.com/problems/number-of-distinct-islands/description/
//https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
//https://www.youtube.com/watch?v=7zmgQSJghpo&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=16
public class NumberOfDistinctIsland {

    public static void main(String[] args) {

    }

    static int countNoOfIsland(int[][] grid) {

        HashSet<ArrayList<String>> res = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ArrayList<String> toBeAdded = new ArrayList<>();
                    dfs(i, j, toBeAdded, visited, i, j, grid);
                    res.add(toBeAdded);
                }
            }
        }

        return res.size();
    }

    private static void dfs(int row, int col, ArrayList<String> toBeAdded,
                            boolean[][] visited, int rowOrg, int colOrg, int[][] grid) {

        visited[row][col] = true;
        toBeAdded.add(toString(row - rowOrg, col - colOrg));

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if (nRow < n && nRow >= 0 && nCol < m && nCol >= 0 &&
                    !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, toBeAdded, visited, rowOrg, colOrg, grid);
            }
        }

    }

    private static String toString(int row, int col) {
        return STR."\{row} \{col}";
    }
}
