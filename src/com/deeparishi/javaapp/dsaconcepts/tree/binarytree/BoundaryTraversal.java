package com.deeparishi.javaapp.dsaconcepts.tree.binarytree;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1?page=1&category=Tree&sortBy=submissions

public class BoundaryTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);
        root.right.right = new TreeNode(7);

        ArrayList<Integer> res = boundaryTraversal(root);

        System.out.println(res);


    }

    static ArrayList<Integer> boundaryTraversal(TreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (node == null)
            return ans;

        if (!isLeaf(node))
            ans.add(node.val);

        addLeftBoundary(node, ans); // Add left boundary
        addLeaves(node, ans);       // Add all leaf nodes
        addRightBoundary(node, ans); // Add right boundary in reverse

        return ans;
    }

    private static void addLeftBoundary(TreeNode node, ArrayList<Integer> ans) {
        TreeNode cur = node.left;
        while (cur != null) {
            if (!isLeaf(cur))
                ans.add(cur.val);
            if (cur.left != null)
                cur = cur.left;
            else
                cur = cur.right;
        }
    }

    private static void addLeaves(TreeNode node, ArrayList<Integer> ans) {

        if (node == null)
            return;

        if (isLeaf(node)) {
            ans.add(node.val);
            return;
        }

        addLeaves(node.left, ans);
        addLeaves(node.right, ans);
    }

    private static void addRightBoundary(TreeNode node, ArrayList<Integer> ans) {
        TreeNode cur = node.right; // Start from the right child
        List<Integer> tmp = new ArrayList<>(); // Temporary list to collect right boundary

        while (cur != null) {
            if (!isLeaf(cur))
                tmp.add(cur.val);
            if (cur.right != null)
                cur = cur.right;
            else
                cur = cur.left;
        }

        // Add the collected nodes in reverse order
        for (int i = tmp.size() - 1; i >= 0; i--) {
            ans.add(tmp.get(i));
        }
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
