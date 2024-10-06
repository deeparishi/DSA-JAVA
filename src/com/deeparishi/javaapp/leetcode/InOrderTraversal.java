package com.deeparishi.javaapp.leetcode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

    //https://leetcode.com/problems/binary-tree-inorder-traversal/?envType=problem-list-v2&envId=binary-tree


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode root, List<Integer> result) {

        if (root != null) {
            helper(root.left, result);
            result.add(root.val);
            helper(root.right, result);
        }

    }
}
