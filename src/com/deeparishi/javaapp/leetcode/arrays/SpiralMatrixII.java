package com.deeparishi.javaapp.leetcode.arrays;

//https://leetcode.com/problems/spiral-matrix-ii/submissions/1443600303/?envType=problem-list-v2&envId=simulation

public class SpiralMatrixII {

    public static void main(String[] args) {

        int[][] res = generateMatrix(4);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];

        int i = 1;
        int topRow = 0;
        int bottomRow = n - 1;
        int leftCol = 0;
        int rightCol = n - 1;

        while (i < (n * n) + 1){

            //Towards Left to right
            for(int col = leftCol; col <= rightCol; col++){
                result[topRow][col] = i++;
            }
            topRow++;

            // Towards top to bottom
            for(int row = topRow; row <= bottomRow; row++){
                result[row][rightCol] = i++;
            }
            rightCol--;

            //Towards Right to left
            for(int col = rightCol; col >= leftCol; col--){
                result[bottomRow][col] = i++;
            }
            bottomRow--;

            //Towards bottom to top
            for(int row = bottomRow; row >= topRow; row--){
                result[row][leftCol] = i++;
            }
            leftCol++;
        }

        return result;
    }
}
