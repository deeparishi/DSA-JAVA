package com.deeparishi.javaapp.cheatsheet.trees.bst;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

//https://www.geeksforgeeks.org/problems/max-and-min-element-in-binary-tree/1?page=5&category=Tree&sortBy=submissions

public class FindMinMax {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(14);
        root.right.right = new TreeNode(25);

        System.out.println(findMax(root));
        System.out.println(findMin(root));
    }

    public static int findMax(TreeNode root) {

        if(root == null) return -1;
        if(root.left == null && root.right == null) return -1;

        return findMax(root, root.val);
    }

    private static int findMax(TreeNode root, int max){

        if(root == null) return max;

        max = Math.max(root.val, max);
        int leftMax = findMax(root.left, max);
        int rightMax = findMax(root.right, max);

        return Math.max(leftMax, rightMax);
    }
    public static int findMin(TreeNode root) {
        if(root == null) return -1;
        if(root.left == null && root.right == null) return root.val;

        return findMin(root, root.val);
    }

    private static int findMin(TreeNode root, int min) {

        if(root == null) return min;

        min = Math.min(root.val, min);

        int leftMin = findMin(root.left, min);
        int rightMin = findMin(root.right, min);

        return Math.min(leftMin, rightMin);
    }
}
