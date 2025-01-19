package com.deeparishi.javaapp.leetcode.tree.bst;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

// https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5185144#overview

public class MinimalTree {

    public static void main(String[] args) {

    }

    public static TreeNode createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    private static TreeNode createMinimalBST(int[] arr, int start, int end) {

        if (end < start) return null;

        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.setLeftChild(createMinimalBST(arr, start, mid - 1));
        n.setRightChild(createMinimalBST(arr, mid + 1, end));
        return n;
    }


}