package com.deeparishi.javaapp.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arrr = {1, 45, 10, 78, 32};
        System.out.println(Arrays.toString(mergeSort(arrr)));

    }


    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] rigth = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, rigth);
    }

    public static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }

}
