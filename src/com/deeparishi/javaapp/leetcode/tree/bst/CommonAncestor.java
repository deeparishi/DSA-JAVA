package com.deeparishi.javaapp.leetcode.tree.bst;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

// https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/lecture/27245676#overview

public class CommonAncestor {

    public static void main(String[] args) {

    }

    public static TreeNode commonAncestor(TreeNode p, TreeNode q) {

        if ((p == null) || (q == null)) {
            return null;
        }

        TreeNode ap = p.parent;
        while (ap != null) {
            TreeNode aq = q.parent;
            while (aq != null) {
                if (aq == ap) {
                    return aq;
                }
                aq = aq.parent;
            }
            ap = ap.parent;
        }
        return null;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == root || q == root)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }
}
