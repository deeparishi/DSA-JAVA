package com.deeparishi.javaapp.selfpractice.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 9, 3, 6, 2, 98, 65, 45, 15, 36};
        selectionSort(arr);
        for (Integer i : arr)
            System.out.println(i);
    }

    static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minidx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minidx])
                    minidx = j;
            }

            if (arr[minidx] != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[minidx];
                arr[minidx] = temp;
            }
        }
    }
}
