package com.deeparishi.javaapp.selfpractice.sorting;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 6, 8, 7, 1, 3, 4};
        quickSortByDescendingOrder(arr, 0, arr.length - 1);
        display(arr);

    }

    private static void quickSort(int[] arr, int start, int end) {

        if(end <= start)
            return;

        int pivot = findPivot(arr, start, end);

        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int findPivot(int[] arr, int start, int end) {

        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j <= end ; j++) {
            if(arr[j] < pivot)
                swap(arr, j, ++i);
        }

        swap(arr, ++i, end);
        return i;
    }

    static void quickSortByDescendingOrder(int[] arr, int start, int end){

        if(end <= start) return;

        int pivot = findPivotForDescendingOrder(arr, start, end);

        quickSortByDescendingOrder(arr, start, pivot - 1);
        quickSortByDescendingOrder(arr, pivot + 1, end );

    }

    private static int findPivotForDescendingOrder(int[] arr, int start, int end) {

        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j <= end; j++){
            if(arr[j] > pivot)
                swap(arr, j, ++i);
        }

        swap(arr, ++i, end);
        return i;
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static void display(int[] newArr) {
        for (int j : newArr) {
            System.out.print(j + " ");
        }
    }

}
