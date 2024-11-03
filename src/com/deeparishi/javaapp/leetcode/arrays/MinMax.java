package com.deeparishi.javaapp.leetcode.arrays;

import java.util.Arrays;

public class MinMax {

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7, 8};
        System.out.println(Arrays.toString(parallel(arr)));
    }

    static int[] parallel(int[] arr){

        Arrays.sort(arr);
        int[] res = new int[arr.length];

        int start = 0;
        int end = arr.length - 1;
        int i= 0;

        while (start < end){
            res[i++] = arr[start];
            res[i++] = arr[end];
            start++;
            end--;
        }

        if (start == end)
            res[arr.length -1] = arr[start];

        return res;
    }
}
