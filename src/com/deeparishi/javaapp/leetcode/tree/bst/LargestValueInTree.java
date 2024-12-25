package com.deeparishi.javaapp.leetcode.tree.bst;

// https://leetcode.com/problems/find-largest-value-in-each-tree-row/?envType=daily-question&envId=2024-12-25
// https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

import com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingnode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(largestValuesUsingDFS(root));
    }

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                max = Math.max(max, curr.value);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }

            res.add(max);
        }
        return res;
    }

    public static List<Integer> largestValuesUsingDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private static void dfs(TreeNode node, int depth, List<Integer> res) {
        if (node == null)
            return;


        if (res.size() <= depth)
            res.add(node.value);
        else
            res.set(depth, Math.max(res.get(depth), node.value));


        dfs(node.left, depth + 1, res);
        dfs(node.right, depth + 1, res);
    }
}
