package com.deeparishi.javaapp.cheatsheet.trees.utls;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

//https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1?page=1&category=Tree&sortBy=submissions

public class Pairs {

    public TreeNode node;

    public int axis;

    public int level;

    public Pairs(TreeNode node, int axis, int col) {
        this.node = node;
        this.axis = axis;
        this.level = col;
    }

    public Pairs(int axis, TreeNode node) {
        this.axis = axis;
        this.node = node;
    }


}
