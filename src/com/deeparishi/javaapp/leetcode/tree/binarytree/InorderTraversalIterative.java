package com.deeparishi.javaapp.leetcode.tree.binarytree;

import java.util.Stack;

//https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/6180854#overview

public class InorderTraversalIterative {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public void inOrderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()){

            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.println(curr.val);
            curr = curr.right;

        }

    }
}
