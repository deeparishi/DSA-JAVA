package com.deeparishi.javaapp.leetcode.top150.array_string;

import java.util.Arrays;

// https://leetcode.com/problems/product-of-array-except-self/

public class ProductSelfExcept {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                productExceptSelf(new int[]{1, 2, 3, 4})
        ));
    }

    public static  int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftProduct = new int[len];
        leftProduct[0] = 1;

        for(int i = 1; i < len; i++)
            leftProduct[i] = nums[i - 1] * leftProduct[i - 1];

        int rightSum = 1;

        for(int i = len - 1; i >=0; i--) {
            leftProduct[i] *= rightSum;
            rightSum *= nums[i];
        }

        return leftProduct;
    }

    public int[] productExceptSelfBruteForce(int[] nums) {
        int[] products = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int val = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                val *= nums[j];
            }
            products[i] = val;
        }

        return products;
    }
}
