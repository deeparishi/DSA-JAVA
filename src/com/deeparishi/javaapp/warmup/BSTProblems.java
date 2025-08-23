package com.deeparishi.javaapp.warmup;

import com.deeparishi.javaapp.practice.TreeNode;

import java.util.*;

public class BSTProblems {


    /* BT/BST Problems */

    public void inOrderIterative(TreeNode node) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode curr = node;

        while (curr != null || !treeNodes.empty()) {
            while (curr != null) {
                curr = curr.left;
                treeNodes.push(curr);
            }
            curr = treeNodes.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        System.out.println(result);
    }

    public void preOrderIterative(TreeNode node) {

        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(node);

        while (!treeNodes.empty()) {
            TreeNode curr = treeNodes.pop();
            System.out.println(curr.val);
            if (curr.right != null)
                treeNodes.push(curr.right);
            if (curr.left != null)
                treeNodes.push(curr.left);
        }
    }

    public void postOrderTraversal(TreeNode node) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(node);

        while (!s1.empty()) {
            TreeNode curr = s1.pop();
            s2.push(curr);

            if (curr.left != null) s1.push(curr.left);
            if (curr.right != null) s1.push(curr.right);
        }

        while (!s2.empty()) {
            System.out.println(s2.pop().val);
        }
    }

    public int maxDepthOfBinaryTreeBFS(TreeNode node) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(node);
        int depth = 0;

        while (!treeNodes.isEmpty()) {
            int level = treeNodes.size();
            for (int i = 0; i < level; i++) {
                TreeNode curr = treeNodes.poll();
                if (curr != null && curr.left != null) treeNodes.offer(curr.left);
                if (curr != null && curr.right != null) treeNodes.offer(curr.right);
            }
            depth++;
        }
        return depth;
    }

    public int maxDepthOfBinaryTreeDFS(TreeNode node) {
        if (node == null)
            return 0;
        int left = maxDepthOfBinaryTreeDFS(node.left);
        int right = maxDepthOfBinaryTreeDFS(node.right);
        return 1 + Math.max(left, right);
    }

    public int minDepthOfBinaryTreeBFS(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int depth = 1;

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.poll();
                if (curr != null && node.right == null && node.left == null)
                    return depth;

                if (curr != null && curr.left != null) queue.offer(curr.left);
                if (curr != null && curr.right != null) queue.offer(curr.right);
            }
            depth++;
        }

        return depth;
    }

    public int minDepthOfBinaryTreeDFS(TreeNode node) {

        if (node == null)
            return 0;

        int left = minDepthOfBinaryTreeDFS(node.left);
        int right = minDepthOfBinaryTreeDFS(node.right);

        if (node.left == null || node.right == null)
            return 1 + Math.max(left, right);

        return 1 + Math.min(left, right);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == root || q == root)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    public boolean isBalanceBST(TreeNode root) {
        return isBalanceBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBalanceBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        if (root.val <= min || root.val >= max) return false;

        return isBalanceBST(root.left, min, root.val) &&
                isBalanceBST(root.right, root.val, max);
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedDFS(root) != -1;
    }

    private int isBalancedDFS(TreeNode root) {

        if (root == null) return 0;

        int left = isBalancedDFS(root.left);
        if (left == -1) return -1;
        int right = isBalancedDFS(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;

    }

    private boolean isValuePresent(TreeNode node, int val) {
        if (node == null) return false;

        if (node.val == val) return true;

        return isValuePresent(node.left, val) || isValuePresent(node.right, val);
    }

    int count = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    public void inOrder(TreeNode root, int k) {
        if (root == null)
            return;

        inOrder(root.left, k);
        count++;

        if (count == k) {
            result = root.val;
            return;
        }

        inOrder(root.right, k);
    }

}
