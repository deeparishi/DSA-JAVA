package com.deeparishi.javaapp.leetcode.arrays;

import java.util.Arrays;

public class ThirdMaxNumber {


    // https://leetcode.com/problems/third-maximum-number/description/?envType=problem-list-v2&envId=array&difficulty=EASY

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{2,2,3,1}));
        System.out.println(thirdMax(new int[]{3,2,1}));
        System.out.println(thirdMax(new int[]{1,2}));
    }

    public static int thirdMax(int[] arr) {

        Arrays.sort(arr);

        int count = 1;
        int max = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {

            if(arr[i] != arr[i+1]){
                count++;
                if (count == 3)
                    return arr[i];
            }
        }

        return max;
    }
}
