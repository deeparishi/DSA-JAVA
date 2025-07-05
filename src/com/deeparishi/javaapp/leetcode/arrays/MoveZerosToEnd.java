package com.deeparishi.javaapp.leetcode.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MoveZerosToEnd {

    public static void main(String[] args) {
        moveZerosToEndOptimal(new int[]{0, 1, 0, -1, 0, 4});
        moveZerosToEndOptimal(new int[]{0, 0, 0, 0});
        moveZerosToEndOptimal(new int[]{1, 2, 3, 4});
        moveZerosToEndOptimal(new int[]{});
        moveZerosToEndOptimal(new int[]{0});
        moveZerosToEndOptimal(new int[]{1});
        moveZerosToEndOptimal(new int[]{0, 1, 0, 0, 1});
        moveZerosToEndOptimal(new int[]{2, 0, 2, 0, 2});
        moveZerosToEndOptimal(new int[]{0, 0, 1, 0, 2, 3});
    }

  
    public static void moveZerosToEndOptimal(int[] arr) {

        int pos = 0;
        for (int num : arr) {
            if (num != 0)
                arr[pos++] = num;
        }

        while (pos < arr.length)
            arr[pos++] = 0;

        System.out.println(STR."After swap: \{Arrays.toString(arr)}");
    }

    public static void moveZerosToEndBrute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] != 0) {
                        swap(i, j, arr);
                        break;
                    }
                }
            }
        }

        System.out.println(STR."After swap: \{Arrays.toString(arr)}");
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}