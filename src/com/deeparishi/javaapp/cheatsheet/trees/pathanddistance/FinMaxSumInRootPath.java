package com.deeparishi.javaapp.cheatsheet.trees.pathanddistance;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

public class FinMaxSumInRootPath {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-25);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println( findMaxSum(root));

    }

    static int findMaxSum(TreeNode node) {
        if (node == null)  return 0;
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findMaxSum(node, max);
        return max[0];
    }

    private static int findMaxSum(TreeNode node, int[] max) {

        if (node == null)
            return 0;

        int left = Math.max(0, findMaxSum(node.left, max));
        int right = Math.max(0, findMaxSum(node.right, max));
        max[0] = Math.max(max[0], left + right + node.val);
        return Math.max(left, right) +  node.val;
    }
}
