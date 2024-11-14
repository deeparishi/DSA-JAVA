package com.deeparishi.javaapp.leetcode.tree.binarytree;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

//https://leetcode.com/problems/count-complete-tree-nodes/submissions/1452695626/?envType=problem-list-v2&envId=binary-tree&difficulty=EASY

public class CountTreeNodes {

    public static void main(String[] args) {

    }

    static int countNodes(TreeNode root) {
        return countNodes(0, root);
    }

     static int countNodes(int count, TreeNode root) {

        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(count, root.right);
    }
}
