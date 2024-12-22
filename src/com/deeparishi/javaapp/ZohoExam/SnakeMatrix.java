package com.deeparishi.javaapp.ZohoExam;

import java.util.ArrayList;
import java.util.List;

public class SnakeMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 100},
                {5, 6, 7, 8, 200},
                {9, 10, 11, 12, 300},
                {13, 14, 15, 16, 400}
        };
        System.out.println(arr[0].length);
        System.out.println(snakeMatrix(arr));
    }

    private static List<Integer> snakeMatrix(int[][] arr) {
        List<Integer> res = new ArrayList<>();
        int len = arr.length;
        int len1 = arr[0].length;


        for (int i = 0; i < arr.length; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < len1; j++) {
                    res.add(arr[i][j]);
                }
            } else {
                for (int j = len1 - 1; j >= 0; j--) {
                    res.add(arr[i][j]);
                }
            }

        }
        return res;
    }
}
