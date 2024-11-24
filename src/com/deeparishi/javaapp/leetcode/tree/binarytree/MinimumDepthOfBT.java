package com.deeparishi.javaapp.leetcode.tree.binarytree;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/?envType=problem-list-v2&envId=depth-first-search

import com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingnode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBT {
    public static void main(String[] args) {

    }
    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node != null && node.left == null && node.right == null)
                    return depth;

                if (node != null && node.left != null) queue.add(node.left);
                if (node != null && node.right != null) queue.add(node.right);
            }

            depth++;
        }

        return depth;
    }
}
