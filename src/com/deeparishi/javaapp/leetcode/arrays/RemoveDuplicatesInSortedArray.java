package com.deeparishi.javaapp.leetcode.arrays;

public class RemoveDuplicatesInSortedArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 3, 4, 4, 5, 6, 7};
        int len = removeDuplicates(arr1);
        for (int i = 0; i < len; i++) {
            System.out.print(STR."\{arr1[i]} ");
        }
    }

    public static int removeDuplicates(int[] arr) {

        int slow = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[slow]) {
                slow++;
                arr[slow] = arr[i];
            }
        }
        return slow + 1;
    }

}