package com.deeparishi.javaapp.leetcode.tree.binarytree;

import com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingnode.TreeNode;

//https://leetcode.com/problems/sum-of-left-leaves/?envType=problem-list-v2&envId=depth-first-search

public class SumOfLeftLeaf {

    public static void main(String[] args) {

    }

    static int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private static int dfs(TreeNode root, boolean isLeft) {

        if(root == null) return 0;

        if(isLeft && root.left == null && root.right == null)
            return root.value;

        int leftSum = dfs(root.left, true);
        int rightSum = dfs(root.right, false);

        return leftSum + rightSum;
    }


}
