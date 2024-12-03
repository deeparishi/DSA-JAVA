package com.deeparishi.javaapp.cheatsheet.trees.basics;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

//https://www.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1?page=1&category=Tree&sortBy=submissions

public class IdenticalTrees {

    public static void main(String[] args) {

    }

    static boolean isIdentical(TreeNode r1, TreeNode r2) {

       if(r1 == null && r2 == null)
           return true;

       if(r1 == null || r2 == null)
           return false;

       return (r1.val == r2.val) &&
               isIdentical(r1.left, r2.left) &&
               isIdentical(r1.right, r2.right);
    }
}
