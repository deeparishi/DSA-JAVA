package com.deeparishi.javaapp.leetcode.tree.binarytree;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

// https://leetcode.com/problems/path-sum?envType=problem-list-v2&envId=tree

public class PathSum {

    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null)
            return false;

        targetSum -= root.val;

        if(root.left == null && root.right == null)
            return targetSum == 0;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
