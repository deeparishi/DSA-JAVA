package com.deeparishi.javaapp.leetcode.tree.binarytree;

//https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/6176202#overview

public class ImplementBinaryTree {

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            addRecursive(root, value);
        }
    }

    private void addRecursive(Node current, int value) {

        if(current == null) return;

        if(current.left == null) current.left = new Node(value);
        else if(current.right == null) current.right = new Node(value);
        else {
            addRecursive(current.left, value);
            addRecursive(current.right, value);
        }

    }

    public void traverseInOrder() {
        traverseInOrderRecursive(root);
    }

    private void traverseInOrderRecursive(Node node) {
        if(node == null) return;
        traverseInOrderRecursive(node.left);
        System.out.print(node.value + " ");
        traverseInOrderRecursive(node.right);
    }




}
