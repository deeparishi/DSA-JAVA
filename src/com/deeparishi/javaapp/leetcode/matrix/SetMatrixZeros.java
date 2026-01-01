package com.deeparishi.javaapp.leetcode.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        setZeroesV4(matrix);
        System.out.println(Arrays.deepToString(matrix));

        matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        setZeroesV4(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }


    // Optimal Approach V3
    public static void setZeroesV4(int[][] matrix) {

        int firstCell = 1;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    if (col != 0)
                        matrix[0][col] = 0;
                    else
                        firstCell = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0)
                    matrix[row][col] = 0;
            }
        }

        if (matrix[0][0] == 0)
            Arrays.fill(matrix[0], 0);

        if (firstCell == 0) {
            for (int row = 0; row < matrix.length; row++)
                matrix[row][0] = 0;
        }
    }


    // Better Approach V3
    public static void setZeroesV3(int[][] matrix) {

        int[] r = new int[matrix.length];
        int[] c = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    r[row] = 1;
                    c[col] = 1;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (r[row] == 1 || c[col] == 1)
                    matrix[row][col] = 0;
            }
        }
    }


    // Brute Force Approach V2
    public static void setZeroesV2(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    markRow(row, matrix);
                    markCol(col, matrix);
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == Integer.MIN_VALUE)
                    matrix[row][col] = 0;
            }
        }
    }

    private static void markRow(int row, int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[row][col] != 0)
                matrix[row][col] = Integer.MIN_VALUE;
        }
    }

    private static void markCol(int col, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][col] != 0)
                matrix[row][col] = Integer.MIN_VALUE;
        }
    }


    // Brute Force V1
    public static void setZeroesV1(int[][] matrix) {

        List<int[]> zeroPositons = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0)
                    zeroPositons.add(new int[]{row, col});
            }
        }

        for(int[] zeroPosition : zeroPositons) {
            int row = zeroPosition[0];
            int col = zeroPosition[1];
            moveLeft(row, col, matrix);
            moveRight(row, col, matrix);
            moveUp(row, col, matrix);
            moveDown(row, col, matrix);
        }
    }

    private static void moveDown(int row, int col, int[][] matrix) {
        for (int r = row; r < matrix.length; r++)
            matrix[r][col] = 0;
    }

    private static void moveUp(int row, int col, int[][] matrix) {
        for (int r = row; r >= 0; r--)
            matrix[r][col] = 0;
    }

    private static void moveRight(int row, int col, int[][] matrix) {
        for (int c = col; c < matrix[0].length; c++)
            matrix[row][c] = 0;
    }

    private static void moveLeft(int row, int col, int[][] matrix) {
        for (int c = col; c >= 0; c--)
            matrix[row][c] = 0;
    }
}
