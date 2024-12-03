package com.deeparishi.javaapp.dsaconcepts.tree.binarytree;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

import java.util.HashMap;

public class PathSumIII {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 8));
    }



    public static int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private static int dfs(TreeNode node, long currentSum,
                           int targetSum, HashMap<Long, Integer> prefixSumCount) {

        if (node == null) return 0;

        currentSum += node.val;
        int count = prefixSumCount.getOrDefault(currentSum - targetSum, 0);
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        count += dfs(node.left, currentSum, targetSum, prefixSumCount);
        count += dfs(node.right, currentSum, targetSum, prefixSumCount);

        // Backtrack by removing the current sum from the prefix sum count
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return count;
    }
}
