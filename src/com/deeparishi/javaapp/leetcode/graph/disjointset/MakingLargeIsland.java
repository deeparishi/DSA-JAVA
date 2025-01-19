package com.deeparishi.javaapp.leetcode.graph.disjointset;

import com.deeparishi.javaapp.leetcode.graph.disjointset.utils.DisjointSet;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/making-a-large-island/

public class MakingLargeIsland {

    public static void main(String[] args) {

//        int[][] grid = new int[][]{
//                {1, 0},
//                {0, 1}
//        };
//
        int[][] grid3 = {
                {1, 1, 0, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {0, 0, 1, 1}
        };

        System.out.println(largestIsland(grid3));
    }

    // Using Disjoint-set
    public static int largestIsland(int[][] grid) {


        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // Step 1: Connect all `1`s using union-find
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) continue;
                for (int i = 0; i < 4; i++) {
                    int newRow = row + dr[i];
                    int newCol = col + dc[i];
                    if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = newRow * n + newCol;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        int max = 0;

        // Step 2: convert each `0` to 1 and calculate the largest island
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;
                Set<Integer> components = new HashSet<>();
                for (int i = 0; i < 4; i++) {
                    int newRow = row + dr[i];
                    int newCol = col + dc[i];
                    if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 1) {
                        int parent = ds.find(newRow * n + newCol);
                        components.add(parent);
                    }
                }

                int total = 0;
                for (Integer parent : components)
                    total += ds.getSize(parent);
                max = Math.max(max, total + 1);
            }
        }

        // Step 3: Handle the edge case where the grid is all `1`s
        for (int i = 0; i < n * n; i++)
            max = Math.max(max, ds.getSize(ds.find(i)));

        return max;
    }

    private static boolean isValid(int row, int col, int n){
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    // Using DFS Approach
    public static int largestIslandOptimal(int[][] grid) {

        int[] size = new int[2 + grid.length * grid.length];
        int numComp = 2;
        int maxSize = 0;

        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++col) {
                if (grid[row][col] == 1) {
                    size[numComp] = dfs(grid, row, col, numComp);
                    maxSize = Math.max(maxSize, size[numComp]);
                    ++numComp;
                }
            }
        }

        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[row].length; ++col) {
                if (grid[row][col] != 0) continue;
                int mergedSize = 1;
                int compA = 0;
                int compB = 0;
                int compC = 0;
                if (row > 0) {
                    compA = grid[row - 1][col];
                    mergedSize += size[compA];
                }
                if (col + 1 < grid[row].length && grid[row][col + 1] != compA) {
                    compB = grid[row][col + 1];
                    mergedSize += size[compB];
                }
                if (row + 1 < grid.length && grid[row + 1][col] != compA && grid[row + 1][col] != compB) {
                    compC = grid[row + 1][col];
                    mergedSize += size[compC];
                }
                if (col > 0 && grid[row][col - 1] != compA && grid[row][col - 1] != compB
                        && grid[row][col - 1] != compC) {
                    mergedSize += size[grid[row][col - 1]];
                }
                maxSize = Math.max(maxSize, mergedSize);
            }
        }
        return maxSize;
    }

    private static int dfs(int[][] grid, int row, int col, int comp) {

        grid[row][col] = comp;
        int size = 1;

        if (row > 0 && grid[row - 1][col] == 1)
            size += dfs(grid, row - 1, col, comp);

        if (row + 1 < grid.length && grid[row + 1][col] == 1)
            size += dfs(grid, row + 1, col, comp);

        if (col > 0 && grid[row][col - 1] == 1)
            size += dfs(grid, row, col - 1, comp);

        if (col + 1 < grid.length && grid[row][col + 1] == 1)
            size += dfs(grid, row, col + 1, comp);

        return size;
    }
}
