package com.deeparishi.javaapp.cheatsheet.trees.basics;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

//https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1?page=1&category=Tree&sortBy=submissions

public class DiameterOfBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);

        System.out.println(diameter(root));
    }

    static int  diameter(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private static int height(TreeNode root, int[] diameter) {
        if(root == null) return 0;

        int leftHeight = height(root.left, diameter);
        int rightHeight = height(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
