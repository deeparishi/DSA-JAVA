package com.deeparishi.javaapp.leetcode.arrays;

// https://leetcode.com/problems/equal-row-and-column-pairs/description/

import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColPairs {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        };

        int[][] matrix2 = {
                {3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}
        };

        int[][] matrix3 = {
                {11, 11},
                {11, 11}
        };

        System.out.println(count(matrix1));
        System.out.println(count(matrix2));
        System.out.println(count(matrix3));
    }

    public static int count(int[][] matrix) {

        int count = 0;
        int colLen = matrix[0].length;

        for (int[] arr : matrix) {
            int y = 0;
            while (y < colLen) {
                boolean flag = true;
                for (int col = 0; col < colLen; col++) {
                    int x = arr[col];
                    int z = matrix[col][y];
                    if (x != z) {
                        flag = false;
                        break;
                    }
                }
                y++;
                if (flag) count++;
            }

        }

        return count;
    }

    public static int countV2(int[][] matrix) {

        int count = 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();

//        for (int row = 0; )


        return count;
    }
}
