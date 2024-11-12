package com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingll;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {

    BinaryTreeNode root;

    BinaryTreeLL() {
        this.root = null;
    }


    void preOrder(BinaryTreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void inOrder(BinaryTreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    void postOrder(BinaryTreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }


    void levelOrder(BinaryTreeNode node) {

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BinaryTreeNode presentNode = queue.remove();
            System.out.print(presentNode.data + " ");
            if (presentNode.left != null)
                queue.add(presentNode.left);
            if (presentNode.right != null)
                queue.add(presentNode.right);
        }
    }

    boolean search(BinaryTreeNode node, BinaryTreeNode root) {

        if (root == null) return false;

        if (node == root) return true;

        boolean leftSearch = search(node, root.left);
        if (leftSearch) return true;

        boolean rightSearch = search(root, root.right);
        return rightSearch;

    }

    void insert(String value) {

        BinaryTreeNode node = new BinaryTreeNode(value);

        if (root == null) {
            root = node;
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode presentNode = queue.remove();
            if (presentNode.left == null) {
                presentNode.left = node;
                return;
            } else if (presentNode.right == null) {
                presentNode.right = node;
                return;
            } else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }


    //Delete a node
    String deleteNode(String value) {

        if (root == null) return null;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode curr = queue.remove();
            if (curr.data.equals(value)) {
                curr.data = getDeepestNode().data;
                deleteDeepestNode();
                return curr.data;
            }
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }

        return null;
    }

    BinaryTreeNode getDeepestNode() {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryTreeNode currentNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }
        return currentNode;
    }

    void deleteDeepestNode() {

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        BinaryTreeNode previousNode = null;
        BinaryTreeNode currentNode = null;

        while (!queue.isEmpty()) {

            previousNode = currentNode;
            currentNode = queue.remove();

            if (currentNode.left == null) {
                previousNode.right = null;
                return;
            } else if (currentNode.right == null) {
                currentNode.left = null;
                return;
            } else {
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }
    }
}