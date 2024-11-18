package com.deeparishi.javaapp.leetcode.tree.binarytree;

import com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingnode.TreeNode;


public class SumOfLeftLeaf {

    public static void main(String[] args) {

    }

    static int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(0, root);
    }

    private static int sumOfLeftLeaves(int sum, TreeNode root) {

        if(root == null) return sum;

        return -1;
    }
}
