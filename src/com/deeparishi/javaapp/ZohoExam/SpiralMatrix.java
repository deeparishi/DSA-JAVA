package com.deeparishi.javaapp.ZohoExam;

import java.util.ArrayList;
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


    public static List<Integer> spiralMatrix(int[][] arr) {
        List<Integer> a = new ArrayList<>();
        if (arr[0].length == 0 && arr.length == 0) {
            return a;
        }
        int cl = 0;
        int rl = 0;
        int cu = arr[0].length - 1;
        int ru = arr.length - 1;

        while (rl <= ru && cl <= cu) {

            for (int i = cl; i <= cu; i++) {
                a.add(arr[rl][i]);
                //System.out.println(arr[rl][i]);
            }
            rl++;

            for (int i = rl; i <= ru; i++) {
                a.add(arr[i][cu]);
                //System.out.println(arr[i][cu]);
            }
            cu--;

            if (cl > cu || rl > ru) {
                break;
            }

            for (int i = cu; i >= cl; i--) {
                a.add(arr[ru][i]);
            }
            ru--;

            for (int i = ru; i >= rl; i--) {
                a.add(arr[i][cl]);
            }
            cl++;
        }

        return a;
    }

}


