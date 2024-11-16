package com.deeparishi.javaapp.leetcode.tree.bst;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

//https://leetcode.com/problems/validate-binary-search-tree/

public class IsValidBST {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        System.out.println(isValidBST(root1));

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println(isValidBST(root2));
    }

    static boolean isValidBST(TreeNode root) {
        return isValidBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isValidBst(TreeNode root, int minValue, int maxValue) {

        if(root == null)
            return true;
        if(root.val <= minValue || root.val >= maxValue)
            return false;
        return isValidBst(root.left, minValue, root.val) && isValidBst(root.right, root.val, maxValue);

    }
}