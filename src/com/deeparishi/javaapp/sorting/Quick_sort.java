package com.deeparishi.javaapp.sorting;

public class Quick_sort {
    public static void QuickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int start = low;
        int end = high;
        int mid = (start + end) / 2;
        int piv = arr[mid];
        while (start <= end) {
            while (arr[start] < piv) {
                start++;
            }
            while (arr[end] > piv) {
                end--;
            }
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        QuickSort(arr, low, end);
        QuickSort(arr, start, high);
    }
}
