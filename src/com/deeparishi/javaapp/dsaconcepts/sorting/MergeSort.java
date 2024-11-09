package com.deeparishi.javaapp.dsaconcepts.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 4, 7, 2, 8, 6, 9, 1};
        int[] newArr = mergeSort(arr);
        display(newArr);
    }

    static int[] mergeSort(int[] arr){

        if(arr.length == 1)
            return arr;

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        return descendingOrder(left, right);
    }

    private static int[] ascendingOrder(int[] left, int[] right) {

        int[] arr = new int[left.length + right.length];
        int leftIdx = 0;
        int rightIdx = 0;
        int idx = 0;

        while (leftIdx < left.length && rightIdx < right.length) {

            if (left[leftIdx] < right[rightIdx]) {
                arr[idx++] = left[leftIdx++];
            } else if (right[rightIdx] < left[leftIdx]) {
                arr[idx++] = right[rightIdx++];
            } else {
                idx++;
            }
        }

        while (leftIdx < left.length) {
            arr[idx++] = left[leftIdx++];
        }


        while (rightIdx < right.length) {
            arr[idx++] = right[rightIdx++];
        }

        return arr;
    }

    private static int[] descendingOrder(int[] left, int[] right) {

        int[] arr = new int[left.length + right.length];
        int leftIdx = 0;
        int rightIdx = 0;
        int idx = 0;

        while (leftIdx < left.length && rightIdx < right.length) {

            if (left[leftIdx] > right[rightIdx]) {
                arr[idx++] = left[leftIdx++];
            } else if (right[rightIdx] > left[leftIdx]) {
                arr[idx++] = right[rightIdx++];
            } else {
                idx++;
            }
        }

        while (leftIdx < left.length) {
            arr[idx++] = left[leftIdx++];
        }


        while (rightIdx < right.length) {
            arr[idx++] = right[rightIdx++];
        }

        return arr;
    }

    private static void display(int[] newArr) {
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }


    // In-pace Approach


}
