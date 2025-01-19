package com.deeparishi.javaapp.leetcode.arrays;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public  static void moveZeroes(int[] nums) {

        int point = 0 ;

        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[point];
                nums[point] = nums[i];
                nums[i] = temp;
                point++;
            }
        }

    }
}
