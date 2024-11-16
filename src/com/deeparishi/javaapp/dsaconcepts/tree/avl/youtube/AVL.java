package com.deeparishi.javaapp.dsaconcepts.tree.avl.youtube;

import com.deeparishi.javaapp.dsaconcepts.tree.utls.BinaryTreeNode;

public class AVL {

    BinaryTreeNode root;

    public AVL() {
        root = null;
    }

    public int insert(int value) {

        if (root == null) {
            root = new BinaryTreeNode(value);
            return value;
        }

        root = insert(root, value);
        return value;
    }

    private BinaryTreeNode insert(BinaryTreeNode root, int value) {

        if (root == null)
            return new BinaryTreeNode(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else if (value > root.value)
            root.right = insert(root.right, value);
        else
            return root;

        root.height = 1 + max(getHeight(root.left), getHeight(root.right));
        int balFactor = balanceFactor(root);

        // LL CASE
        if (balFactor > 1 && value < root.left.value)
            return rightRotate(root);

        // LR CASE
        if (balFactor > 1 && value > root.left.value) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR CASE
        if (balFactor < -1 && value > root.right.value)
            return leftRotate(root);

        // RL CASE
        if (balFactor < -1 && value < root.right.value) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private BinaryTreeNode leftRotate(BinaryTreeNode z) {

        BinaryTreeNode y = z.right;
        BinaryTreeNode t3 = y.left;

        y.left = z;
        z.right = t3;

        z.height = 1 + max(getHeight(z.left), getHeight(z.right));
        y.height = 1 + max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    private BinaryTreeNode rightRotate(BinaryTreeNode z) {

        BinaryTreeNode y = z.left;
        BinaryTreeNode t3 = y.right;

        y.right = z;
        z.left = t3;

        z.height = 1 + max(getHeight(z.left), getHeight(z.right));
        y.height = 1 + max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    private int getHeight(BinaryTreeNode node) {
        if (node == null) return -1;
        return node.height;
    }

    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private int balanceFactor(BinaryTreeNode node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}