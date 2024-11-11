package com.deeparishi.javaapp.leetcode.binarysearch;

public class Search2DMatrix {

    public static void main(String[] args) {

        int[][] arr = new int[][]
//                {
//                        {1,3,5,7},
//                        {10,11,16,20},
//                        {23,30,34,60}
//                };
                {
                        {1,3}
                };
        System.out.println(searchMatrix(arr, 3));
    }

    static boolean searchMatrix(int[][] matrix, int target) {

        int colLen = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {

            if(target >= matrix[i][0]   && target <= matrix[i][colLen - 1]){
                return binarySearch(matrix[i], target);
            }
        }

        return false;
    }

    static boolean binarySearch(int[] matrix, int target) {

        int start = 0;
        int end = matrix.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (matrix[mid] == target)
                return true;

            else if (matrix[mid] < target)
                start = mid + 1;

            else
                end = mid - 1;
        }

        return false;
    }
}
