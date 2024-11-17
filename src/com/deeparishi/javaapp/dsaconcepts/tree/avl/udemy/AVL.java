package com.deeparishi.javaapp.dsaconcepts.tree.avl.udemy;

import com.deeparishi.javaapp.dsaconcepts.tree.utls.BinaryTreeNode;
public class AVL {

    BinaryTreeNode root;

    public AVL() {
        root = null;
    }

    public int insert(int value) {
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

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balanceFactor = balanceFactor(root);

        //LL Case
        if (balanceFactor > 1 && value < root.left.value) {
            return rightRotate(root);
        }

        //RR Case
        if (balanceFactor < -1 && value > root.right.value)
            return leftRotate(root);

        //LR Case
        if (balanceFactor > 1 && value > root.left.value) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //RL Case
        if (balanceFactor < -1 && value < root.right.value) {
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

        z.height = 1 + Math.max(getHeight(z.left), getHeight(z.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    private BinaryTreeNode rightRotate(BinaryTreeNode z) {

        BinaryTreeNode y = z.left;
        BinaryTreeNode t3 = y.right;

        y.right = z;
        z.left = t3;

        z.height = 1 + Math.max(getHeight(z.left), getHeight(z.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }

    private int balanceFactor(BinaryTreeNode root) {
        if (root == null) return 0;
        return getHeight(root.left) - getHeight(root.right);
    }

    private int getHeight(BinaryTreeNode node) {
        if (node == null) return -1;
        return node.height;
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

    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(BinaryTreeNode root, int value) {

        if (root == null) return false;

        if (root.value == value) return true;

        if (value < root.value)
            return search(root.left, value);
        else
            return search(root.right, value);
    }

    // Delete a Node Logics
    public int delete(int value) {
        root = delete(root, value);
        return value;
    }

    private BinaryTreeNode delete(BinaryTreeNode root, int value) {

        if (root == null) return null;

        if (value < root.value)
            root.left = delete(root.left, value);
        else if (value > root.value)
            root.right = delete(root.right, value);
        else {

            // If Node has one child either left/right
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node has two children both left & right
            BinaryTreeNode min = minimumNode(root.right);
            root.value = min.value;
            root.right = delete(root.right, root.value);
        }

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balanceFactor = balanceFactor(root);

        // LL Case
        if (balanceFactor > 1 && getHeight(root.left) >= 0)
            return rightRotate(root);

        // LR Case
        if (balanceFactor > 1 && getHeight(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //RR Case
        if (balanceFactor < -1 && getHeight(root.right) <= 0) {
            return leftRotate(root);
        }

        if (balanceFactor < -1 && getHeight(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private BinaryTreeNode minimumNode(BinaryTreeNode node) {

        if (node.left == null)
            return null;
        BinaryTreeNode min = node;
        while (min.left != null) {
            min = min.left;
        }

        return min;

//      using recursion
//      return minimumNode(node.left);
    }

}