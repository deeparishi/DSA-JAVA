package com.deeparishi.javaapp.cheatsheet.trees.basics;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

public class LowestCommonAncestor {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null)
            return right;

        else if(right == null)
            return left;
        else
            return root;
    }
}
