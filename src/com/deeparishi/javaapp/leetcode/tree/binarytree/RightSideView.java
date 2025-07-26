package com.deeparishi.javaapp.leetcode.tree.binarytree;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-right-side-view/

public class RightSideView {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        dfs(root, 0, lists);
        return lists;
    }

    public static void dfs(TreeNode root, int depth, List<Integer> res) {

        if (root == null)
            return;

        if (depth == res.size())
            res.add(root.val);

        dfs(root.right, depth + 1, res);
        dfs(root.left, depth + 1, res);
    }
}