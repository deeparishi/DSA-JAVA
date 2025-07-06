package com.deeparishi.javaapp.leetcode.arrays;

import java.util.Arrays;

// https://www.youtube.com/watch?v=n7uwj04E0I4

public class MergeSortTwoArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        mergeSortedArrayOptimalOne(arr1, arr2);
    }

    public static void mergeSortedArrayOptimalOne(int[] arr1, int[] arr2) {

        int left = arr1.length - 1;
        int right = 0;

        while (left >= 0 && right < arr2.length) {

            if (arr2[right] < arr1[left]) {
                int temp = arr2[right];
                arr2[right] = arr1[left];
                arr1[left] = temp;
                left--;
                right++;
            } else
                break;
            ;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void mergeSortedArrayBrute(int[] arr1, int[] arr2) {

        int len1 = arr1.length;
        int len2 = arr2.length;

        int[] arr3 = new int[len1 + len2];
        int left = 0;
        int right = 0;
        int index = 0;

        while (left < len1 && right < len2) {
            if (arr1[left] <= arr2[right]) {
                arr3[index] = arr1[left];
                index++;
                left++;
            } else {
                arr3[index] = arr2[right];
                index++;
                right++;
            }
        }

        while (left < len1) {
            arr3[index++] = arr1[left++];
        }

        while (right < len2) {
            arr3[index++] = arr2[right++];
        }

        for (int i = 0; i < arr3.length; i++) {
            if (i < len1) {
                arr1[i] = arr3[i];
            } else {
                arr2[i - len1] = arr3[i];
            }
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

}