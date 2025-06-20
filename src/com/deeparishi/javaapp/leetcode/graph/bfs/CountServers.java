package com.deeparishi.javaapp.leetcode.graph.bfs;

// https://leetcode.com/problems/count-servers-that-communicate

public class CountServers {

    public static void main(String[] args) {

        int[][] grid1 = {
                {1, 0},
                {0, 1}
        };

        int[][] grid2 = {
                {1, 0},
                {1, 1}
        };

        int[][] grid3 = {
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        int[][] grid4 = {
                {1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0}
        };

        System.out.println(countServers(grid1));
        System.out.println(countServers(grid2));
        System.out.println(countServers(grid3));
        System.out.println(countServers(grid4));
    }

    public static int countServers(int[][] grid) {

        int rowLen = grid.length;
        int colLen = grid[0].length;

        int[] rowServers = new int[rowLen];
        int[] colServers = new int[colLen];

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == 1) {
                    rowServers[row]++;
                    colServers[col]++;
                }
            }
        }

        int connected = 0;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == 1 && (rowServers[row] > 1 || colServers[col] > 1))
                    connected++;
            }
        }


        return connected;

    }

    private static boolean isValid(int newRow, int newCol, int rowLen, int colLen) {
        return newRow >= 0 && newCol >= 0 && newRow < rowLen && newCol < colLen;
    }
}