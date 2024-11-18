package com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingnode;

public class TreeNode {

    public int value;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int value){
        this.value = value;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }

}
