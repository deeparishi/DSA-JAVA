package com.deeparishi.javaapp.old.leetcode;

public class maxProductOfTwoElement {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {

        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;

        for (int i : nums){

            if(i >= a){
                b = a;
                a = i;
            } else if (i > b) {
                b = i;
            }
        }

        return (nums[a] - 1) * (nums[b] -1);
    }
}
