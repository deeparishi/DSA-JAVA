package com.deeparishi.javaapp.leetcode.tree.binarytree;

//https://leetcode.com/problems/binary-tree-preorder-traversal/description/?envType=problem-list-v2&envId=binary-tree&difficulty=EASY

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {

    public static void main(String[] args) {

    }

    static List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal(new ArrayList<>(), root);
    }

    static List<Integer> preorderTraversal(List<Integer> values, TreeNode root){

        if(root == null) return values;

        values.add(root.val);
        preorderTraversal(values, root.left);
        preorderTraversal(values, root.right);
        return values;

    }
}
