package com.deeparishi.javaapp.bst;

import com.deeparishi.javaapp.node.Node;

public class BinaryTree {

    Node root;

    public BinaryTree(int d) {
        root = new Node(d);
    }

    public void insertLeft(Node root, int i) {
        root.left = new Node(i);
    }

    public void insertRight(Node root, int i) {
        root.right = new Node(i);
    }


    // Pre-order traversal
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(STR."\{root.data} ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // In-order traversal
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(STR."\{root.data} ");
            inOrder(root.right);
        }
    }

    // Post-order traversal
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(STR."\{root.data} ");
        }
    }
}
