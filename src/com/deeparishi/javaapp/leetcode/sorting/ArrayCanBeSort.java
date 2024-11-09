package com.deeparishi.javaapp.leetcode.sorting;

//https://leetcode.com/problems/find-if-array-can-be-sorted/description/?envType=daily-question&envId=2024-11-06

public class ArrayCanBeSort {
    public static void main(String[] args) {

        System.out.println(canSortArray(new int[]{18, 3, 8})); //False
        System.out.println(canSortArray(new int[]{60, 20})); //False
        System.out.println(canSortArray(new int[]{8, 4, 2, 30, 15})); //True
        System.out.println(canSortArray(new int[]{3, 16, 8, 4, 2})); //False

    }

    static boolean canSortArray(int[] arr) {

        int prevMax = Integer.MIN_VALUE;
        int currMin = arr[0];
        int currMax = arr[0];
        int bit = Integer.bitCount(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if(bit == Integer.bitCount(arr[i])){
                currMin = Math.min(currMin, arr[i]);
                currMax = Math.max(currMax, arr[i]);
            }else {
                if(currMin < prevMax)
                    return false;
                prevMax = currMax;
                currMin = arr[i];
                currMax = arr[i];
                bit = Integer.bitCount(arr[i]);
            }
        }

        return currMin > prevMax;
    }
}
