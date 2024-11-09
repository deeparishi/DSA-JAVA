package com.deeparishi.javaapp.selfpractice.sorting;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 9, 3, 6, 2, 98, 65, 45, 15, 36};
        bubbleSort(arr);
        for (Integer i : arr)
            System.out.println(i);
    }

    static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
