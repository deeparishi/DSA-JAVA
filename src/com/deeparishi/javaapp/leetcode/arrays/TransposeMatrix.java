package com.deeparishi.javaapp.leetcode.arrays;

import java.util.Arrays;

public class TransposeMatrix {

    //https://leetcode.com/problems/transpose-matrix/?envType=problem-list-v2&envId=array&difficulty=EASY

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrixTwo = {
                {1,2,3},
                {4,5,6}
        };

        System.out.println(Arrays.deepToString(transpose(matrix)));
        System.out.println(Arrays.deepToString(transpose(matrixTwo)));
    }

    public static int[][] transpose(int[][] matrix) {

        int[][] result = new int[matrix[0].length][matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                result[col][row] = matrix[row][col];
            }
        }


        return result;

    }

    public String maxProduct(int[] intArray) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : intArray){
            if(num > firstMax){
                secondMax = firstMax;
                firstMax = num;
            }else if(num > secondMax){
                secondMax = num;
            }
        }

        int product = firstMax * secondMax;

        return Integer.toString(firstMax) + "," + Integer.toString(secondMax);
    }
}
