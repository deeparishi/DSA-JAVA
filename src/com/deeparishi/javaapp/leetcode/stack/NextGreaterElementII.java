package com.deeparishi.javaapp.leetcode.stack;

import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-ii/?envType=problem-list-v2&envId=stack&difficulty=MEDIUM

public class NextGreaterElementII {

    public static void main(String[] args) {
        int[] i = nextGreaterElementsOptimized(new int[]{1,2,1});
        for (int a : i)
            System.out.println(a);
    }


    static int[] nextGreaterElementsBruteForce(int[] nums) {

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < i + nums.length; j++) {
                int ind = j % nums.length;
                if(nums[ind] > nums[i]){
                    res[i] = nums[ind];
                    break;
                }else{
                    res[i] = -1;
                }
            }
        }

        return res;

    }

    static int[] nextGreaterElementsOptimized(int[] nums) {

        int[] res = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        for ( int i = 2 * n-1; i >= 0; i--) {
            int ind = i % nums.length;

            while (!st.isEmpty() &&  st.peek()<= nums[ind])
                st.pop();

            if(i < n)
                    res[i] =  !st.isEmpty() ? st.peek() : -1;

            st.push(nums[ind]);

        }

        return res;

    }
}
