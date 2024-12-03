package com.deeparishi.javaapp.leetcode.tree.binarytree;

import com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingnode.TreeNode;

//https://leetcode.com/problems/add-one-row-to-tree/?envType=problem-list-v2&envId=breadth-first-search

public class AddOneRowToTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        addRow(root, val, depth);
        return root;
    }

    private void addRow(TreeNode root, int val, int depth) {

        if(root == null) return;

        if(depth == 1){
            TreeNode leftChild = new TreeNode(val);
            TreeNode rightChild = new TreeNode(val);

            leftChild.left = root.left;
            rightChild.right = root.right;

            root.left = leftChild;
            root.right = rightChild;
        }else {
            addRow(root.left, val, depth -1);
            addRow(root.right, val, depth -1);
        }
    }
}
