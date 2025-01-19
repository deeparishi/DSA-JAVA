package com.deeparishi.javaapp.leetcode.tree.bst;

// https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5188528#overview

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

public class CheckBalanced {

    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static int checkHeight(TreeNode root) {
        if (root == null)
            return -1;


        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Propagate error up

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Propagate error up

        int heightDiff = leftHeight - rightHeight;

        if (Math.abs(heightDiff) > 1)
            return Integer.MIN_VALUE; // Found error -> pass it back
        else
            return Math.max(leftHeight, rightHeight) + 1;

    }
}
