package com.deeparishi.javaapp.old.bst;

import com.deeparishi.javaapp.old.node.Node;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree(){
        root = null;
    }

    public BinarySearchTree(int value){
        root = new Node(value);
    }

    public Node insert(Node root, int value){

        if(root == null)
            return new Node(value);

        if(value < root.data)
            root.left = insert(root.left, value);
        else if (value > root.data)
            root.right = insert(root.right, value);

        return root;
    }

    public void insert(int value){
        root = insert(root, value);
    }

    public int search(Node root, int value) {

        if (root == null)
            return -1;

        else if (root.data == value)
            return value;

        else if (value < root.data)
            return search(root.left, value);

        else
            return search(root.right, value);
    }

    public void delete(int value){
        root = delete(root, value);
    }

    public Node delete(Node root, int value) {

        if (root == null)
            return null;

        if (value > root.data)
            root.right = delete(root.right, value);

        else if (value < root.data)
            root.left = delete(root.left, value);

        else {

            if (root.left == null)
                return root.right;

            else if (root.right == null)
                return root.left;

            else {
                root.data = min(root.right);
                root.right = delete(root.right, root.data);
            }
        }

        return root;
    }

    private int min(Node root) {

        int min = root.data;

        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }

        return min;
    }

    public void print() {
        System.out.println("In-order traversal:");
        inOrder(root);

        System.out.println("\nPre-order traversal:");
        preOrder(root);

        System.out.println("\nPost-order traversal:");
        postOrder(root);
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
