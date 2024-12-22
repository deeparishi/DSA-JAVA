package com.deeparishi.javaapp.ZohoExam;

import java.util.Arrays;

public class FirstLargestFirstSmallest {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 9, 2, 4, 6, 2};
        array(arr);
    }

    public static void array(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] newArr = new int[n];
        int left = 0;
        int right = n - 1;
        int i = 0;


        while (left < right) {
            newArr[i++] = arr[right--];
            newArr[i++] = arr[left++];
        }
        if (left == right) {
            newArr[i] = arr[left];
        }
        for (int j = 0; j < newArr.length; j++) {
            System.out.print(newArr[j]);
        }

    }
}

