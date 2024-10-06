package com.deeparishi.javaapp.avl;

import com.deeparishi.javaapp.node.Node;

public class AVL {

    private Node root;

    public AVL(int val) {
        root = new Node(val);
    }

    public AVL() {
        root = null;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node root, int val) {

        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }

        root.height = 1 + max(height(root.left), height(root.right));
        int balFactor = balanceFactor(root);

        // LL Case
        if (balFactor > 1 && val < root.left.data) {
            return rightRotate(root);
        }

        // RR Case
        if (balFactor < -1 && val > root.right.data) {
            return leftRotate(root);
        }

        // LR Case
        if (balFactor > 1 && val > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RL Case
        if (balFactor < -1 && val < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private Node rightRotate(Node z) {

        Node y = z.left;
        Node t3 = y.right;

        y.right = z;
        z.left = t3;

        z.height = 1 + max(height(z.left), height(z.right));
        y.height = 1 + max(height(y.left), height(y.right));

        return y;
    }

    private Node leftRotate(Node z) {

        Node y = z.right;
        Node t3 = y.left;

        y.left = z;
        z.right = t3;

        z.height = 1 + max(height(z.left), height(z.right));
        y.height = 1 + max(height(y.left), height(y.right));

        return y;
    }

    public int height(Node node) {
        if (node == null)
            return -1;
        return node.height;
    }

    public int max(int a, int b) {
        return Math.max(a, b);
    }

    public int balanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    public void print() {
        print(root);
    }

    public void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.println(STR."Node: \{root.data} Height: \{root.height}");
            print(root.right);
        }
    }
    
}
