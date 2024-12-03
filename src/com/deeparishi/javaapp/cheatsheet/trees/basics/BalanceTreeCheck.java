package com.deeparishi.javaapp.cheatsheet.trees.basics;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

//https://www.geeksforgeeks.org/problems/check-for-balanced-tree/1?page=1&category=Tree&sortBy=submissions

public class BalanceTreeCheck {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {

        return dfsForHeight(root) != -1;
    }

    private int dfsForHeight(TreeNode root) {

        if(root == null) return 0;

        int leftHeight = dfsForHeight(root.left);
        if(leftHeight == -1)
            return -1;

        int rightHeight = dfsForHeight(root.right);
        if(rightHeight == -1)
            return -1;

        if(Math.abs(leftHeight-rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
