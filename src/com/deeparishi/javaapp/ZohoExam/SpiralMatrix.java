package com.deeparishi.javaapp.ZohoExam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {


        int[][] arr = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int[][] arr1 = {{1, 78, 21, 11, 742},
                {6, 7, 8, 9, 10},
                {11, 12, 45213, 14, 1235},
                {16, 17, 78528, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] arr2 = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},

        };
        // System.out.println(arr[1].length);
        System.out.println();
        System.out.println();
        System.out.println(spiralMatrix(arr));
    }


    public static List<Integer> spiralMatrix(int[][] matrix) {
        if (matrix[0].length == 0 && matrix.length == 0) {
            return Collections.emptyList();
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        List<Integer> list = new ArrayList<>();

        while(left <= right && top <= bottom) {

            for(int i = left; i <= right; i++)
                list.add(matrix[top][i]);
            top++;

            for(int i = top; i <= bottom; i++)
                list.add(matrix[i][right]);
            right--;

            if(left > right || top > bottom) break;

            for(int i = right; i >= left; i--)
                list.add(matrix[bottom][i]);
            bottom--;

            for(int i = bottom; i >= top; i--)
                list.add(matrix[i][left]);
            left++;
        }

        return list;
    }

}


