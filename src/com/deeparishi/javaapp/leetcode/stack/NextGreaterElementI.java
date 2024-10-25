package com.deeparishi.javaapp.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/?envType=problem-list-v2&envId=stack&difficulty=EASY

public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] i = nextGreaterElementNew(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        for (int a : i)
            System.out.println(a);
    }

    static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = i; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }

        return res;
    }

    static int[] nextGreaterElementNew(int[] nums1, int[] nums2) {

        Map<Integer, Integer> nge = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if (!st.isEmpty())
                nge.put(nums2[i], st.peek());

            else
                nge.put(nums2[i], -1);

            st.push(nums2[i]);
        }

        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++)
            res[i] = nge.get(nums1[i]);

        return res;
    }
}
