package com.deeparishi.javaapp.leetcode.tree.binarytree;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-level-order-traversal/

public class LevelOrderTraversal {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    public static void dfs(TreeNode root, int depth, List<List<Integer>> result) {

        if (root == null)
            return;

        if (depth == result.size())
            result.add(new ArrayList<>());

        result.get(depth).add(root.val);

        dfs(root.left, depth + 1, result);
        dfs(root.right, depth + 1, result);
    }
}