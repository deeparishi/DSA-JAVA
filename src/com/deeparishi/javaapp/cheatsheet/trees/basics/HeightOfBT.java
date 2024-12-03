package com.deeparishi.javaapp.cheatsheet.trees.basics;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

//https://www.geeksforgeeks.org/problems/height-of-binary-tree/1?page=1&category=Tree&sortBy=submissions

public class HeightOfBT {

    public static void main(String[] args) {

    }

     static int height(TreeNode node) {

        if(node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
