package com.deeparishi.javaapp.dsaconcepts.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 3, 6, 2, 98, 65, 45, 15, 36};
        insertionSort(arr);
        for (Integer i : arr)
            System.out.println(i);

    }

    static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = temp;
        }
    }
}
