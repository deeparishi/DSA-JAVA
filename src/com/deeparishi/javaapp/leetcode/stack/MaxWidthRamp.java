package com.deeparishi.javaapp.leetcode.stack;

import java.util.Stack;

//https://leetcode.com/problems/maximum-width-ramp/submissions/?envType=problem-list-v2&envId=stack&difficulty=MEDIUM%2CEASY

public class MaxWidthRamp {

    public static void main(String[] args) {
        System.out.println(maxWidthRamp(new int[]{6,0,8,2,1,5}));
    }

    static int maxWidthRamp(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if(stack.isEmpty() || nums[stack.peek()] > nums[i])
                stack.push(i);
        }

        int max = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                int k = stack.pop();
                max = Math.max(max, i - k);
            }
        }

        return max;
    }
}
