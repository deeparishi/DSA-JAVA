package com.deeparishi.javaapp.leetcode.tree.binarytree;

import com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingnode.TreeNode;

//https://leetcode.com/problems/balanced-binary-tree/description/?envType=problem-list-v2&envId=depth-first-search

public class IsBalanced {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = dfsHeight(node.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = dfsHeight(node.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }


}
