package com.deeparishi.javaapp.leetcode.arrays;

// https://leetcode.com/problems/check-if-grid-satisfies-conditions/
public class GridSatisfiesCondition {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 0, 2},
                {1, 0, 2}
        };

        System.out.println(satisfiesConditions(arr));

        int[][] arr2 = {
                {1, 1, 1},
                {0, 0, 0}
        };

        System.out.println(satisfiesConditions(arr2));

        int[][] arr3 = {
                {1}, {2}, {3}
        };

        System.out.println(satisfiesConditions(arr3));

    }

    /**
     * Equal to the cell below it, i.e. grid[i][j] == grid[i + 1][j] (if it exists).
     * Different from the cell to its right, i.e. grid[i][j] != grid[i][j + 1] (if it exists).
     * Return true if all the cells satisfy these conditions, otherwise, return false.
     */
    public static boolean satisfiesConditions(int[][] grid) {

        int rowLen = grid.length;
        int colLen = grid[0].length;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (row + 1 < rowLen && grid[row][col] != grid[row + 1][col]) return false;
                if (col + 1 < colLen && grid[row][col] == grid[row][col + 1]) return false;
            }
        }

        return true;
    }
}
