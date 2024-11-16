package com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingnode;

import com.deeparishi.javaapp.dsaconcepts.tree.utls.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    TreeNode root;

    public BinaryTree(){
        root = null;
    }

    public int insert(int value){

        if(root == null){
            root = new TreeNode(value);
            return value;
        }
        insert(root,value);
        return value;
    }

    private void insert(TreeNode root, int value) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode curr = queue.poll();

            if (curr.left == null) {
                curr.left = new TreeNode(value);
                break;
            } else
                queue.offer(curr.left);

            if (curr.right == null) {
                curr.right = new TreeNode(value);
                break;
            } else
                queue.offer(curr.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode root) {

        if(root != null){
            System.out.println(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
