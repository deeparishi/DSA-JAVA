package com.deeparishi.javaapp.cheatsheet.trees.basics;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

public class SumTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(10);
        root.right = new TreeNode(30);
        System.out.println(isSumTree(root));
    }

    static boolean isSumTree(TreeNode root) {

        return dfs(root) != -1;
    }

    private static int dfs(TreeNode root) {

        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return root.val;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (root.val != left + right)
            return -1;

        return root.val + left + right;
    }
}
