package com.deeparishi.javaapp.leetcode.tree.binarytree;

import com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingnode.TreeNode;

//https://leetcode.com/problems/symmetric-tree/?envType=problem-list-v2&envId=binary-tree&difficulty=EASY

public class SymmetricTree {

    public static void main(String[] args) {

        TreeNode symmetricRoot = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );


        System.out.println("Asymmetric Tree Test: " + isSymmetric(symmetricRoot));
    }

    static boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {

        if(left == null || right == null) return left == right;

        return (left.value == right.value)
                && isSymmetricHelper(left.left, right.right)
                && isSymmetricHelper(left.right, right.left);


    }
}
