package com.deeparishi.javaapp.leetcode.arrays;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/shuffle-integers2401/1?page=2&category=Recursion&sortBy=submissions

public class ShuffleIntegers {

    public static void main(String[] args) {
        long[] arr = new long[]{1,2,3,4, 5,6};
        shuffleArray(arr, arr.length);
        for (long l : arr) {
            System.out.println(l);
        }
    }

        static void shuffleArray(long arr[], int n)
        {
         int mid = n / 2;

            for (int i = 0; i < mid; i++) {
                long half = arr[mid + i];
                for (int j = mid + i; j > 2 * i + 1; j--) {
                    arr[j] = arr[j-1];
                }
                arr[2 * i + 1] = half;
            }
        }
}
