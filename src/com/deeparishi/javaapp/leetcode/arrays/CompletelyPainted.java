package com.deeparishi.javaapp.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/first-completely-painted-row-or-column

public class CompletelyPainted {

    public static void main(String[] args) {

        int[] arr1 = {1, 3, 4, 2};
        int[][] grid1 = {
                {1, 4},
                {2, 3}
        };

        int[] arr2 = {2, 8, 7, 4, 1, 3, 5, 6, 9};
        int[][] grid2 = {
                {3, 2, 5},
                {1, 4, 6},
                {8, 7, 9}
        };

        int[] arr3 = {1, 4, 5, 2, 6, 3};
        int[][] grid3 = {
                {4, 3, 5},
                {1, 2, 6}
        };

        System.out.println(firstCompleteIndex(arr1, grid1));
        System.out.println(firstCompleteIndex(arr2, grid2));
        System.out.println(firstCompleteIndex(arr3, grid3));

        System.out.println("-------------V2-----------------------");

        System.out.println(firstCompleteIndexV2(arr1, grid1));
        System.out.println(firstCompleteIndexV2(arr2, grid2));
        System.out.println(firstCompleteIndexV2(arr3, grid3));

    }

    public static int firstCompleteIndex(int[] arr, int[][] mat) {

        Map<Integer, int[]> map = new HashMap<>();
        int[] rowFreq = new int[mat.length];
        int[] colFreq = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                map.put(mat[i][j], new int[]{i, j});
        }

        for (int i = 0; i < arr.length; i++) {

            int[] idx = map.get(arr[i]);
            int row = idx[0];
            int col = idx[1];

            rowFreq[row]++;
            colFreq[col]++;

            if (rowFreq[row] == mat[0].length || colFreq[col] == mat.length)
                return i;
        }

        return -1;
    }

    public static int firstCompleteIndexV2(int[] arr, int[][] mat) {

        int rowLen = mat.length;
        int colLen = mat[0].length;
        int[] rowArr = new int[rowLen * colLen + 1];
        int[] colArr = new int[rowLen * colLen + 1];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int num = mat[i][j];
                rowArr[num] = i;
                colArr[num] = j;
            }
        }

        int[] rowFreq = new int[rowLen];
        int[] colFreq = new int[colLen];

        for (int i = 0; i < arr.length; i++) {

            int val = arr[i];
            int x = rowArr[val];
            int y = colArr[val];

            rowFreq[x]++;
            colFreq[y]++;

            if (rowFreq[x] >= colLen || colFreq[y] >= rowLen) return i;
        }

        return -1;
    }

}
