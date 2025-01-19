package com.deeparishi.javaapp.leetcode.tree.utils;

public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode parent;

    public int size = 0;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void setLeftChild(TreeNode left) {
        this.left = left;
        if (left != null)
            left.parent = this;
    }

    public void setRightChild(TreeNode right) {
        this.right = right;
        if (right != null)
            right.parent = this;
    }

    public int height() {
        int leftHeight = left != null ? left.height() : 0;
        int rightHeight = right != null ? right.height() : 0;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
