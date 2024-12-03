package com.deeparishi.javaapp.dsaconcepts.tree.binarytree;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/submissions/1465124206/

public class SumRootToLeafPath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right= new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        return calculateSum(root, 0);
    }

    private static int calculateSum(TreeNode node, int currentSum) {
        if (node == null) return 0;
        currentSum = currentSum * 10 + node.val;
        if (node.left == null && node.right == null) return currentSum;
        return calculateSum(node.left, currentSum) + calculateSum(node.right, currentSum);
    }


}
