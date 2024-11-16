package com.deeparishi.javaapp.dsaconcepts.tree.bst;

import com.deeparishi.javaapp.dsaconcepts.tree.utls.BinaryTreeNode;
import com.deeparishi.javaapp.old.node.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    BinaryTreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public int insert(int value) {

        if (root == null) {
            root = new BinaryTreeNode(value);
            return value;
        }

        BinaryTreeNode node = insert(value, root);
        return value;
    }

    private BinaryTreeNode insert(int value, BinaryTreeNode root) {

        if (root == null) return new BinaryTreeNode(value);

        if (value < root.value)
            root.left = insert(value, root.left);
        else
            root.right = insert(value, root.right);

        return root;
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

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BinaryTreeNode root) {
        if (root != null) {
            preOrder(root.left);
            System.out.print(root.value + " ");
            preOrder(root.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(BinaryTreeNode root) {
        if (root != null) {
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.value + " ");
        }
    }

    public void levelOrder(){
        levelOrder(root);
    }

    private void levelOrder(BinaryTreeNode root) {

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            BinaryTreeNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null)
                queue.add(presentNode.left);
            if (presentNode.right != null)
                queue.add(presentNode.right);
        }
    }

    public boolean search(int value){
        BinaryTreeNode node = search(root, value);
        return node != null;
    }

    private BinaryTreeNode search(BinaryTreeNode root, int value) {

        if (root == null || root.value == value)
            return root;

        else if (value < root.value)
            return search(root.left, value);

        else
            return search(root.right, value);
    }

    public int delete(int value) {
        root = delete(root, value);
        if (root == null)
            return -1;
        return value;
    }

    private BinaryTreeNode delete(BinaryTreeNode root, int value) {

        if (root == null)
            return null;

        if (value < root.value)
            root.left = delete(root.left, value);
        else if (value > root.value)
            root.right = delete(root.right, value);

        else {

            // Below two lines to delete, if node has either one/two child or without child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

                // Below is to delete the node with two children
            else {

                // Find the min value from right side of node then assign that value to curr root
                root.value = min(root.right);

                // Then delete that min value from right subtree
                root.right = delete(root.right, root.value);
            }
        }

        return root;
    }

    private int min(BinaryTreeNode root) {

        // To find the min value, so far the min value always implies on left subtree
        int min = root.value;

        while (root.left != null){
            min = root.left.value;
            root = root.left;
        }

        return min;
    }


}

/**  DELETION SCENARIO'S

 * 1) If Leaf Node? Make the parent point to null
 * 2) If Node with One child either Left/Right? Point the single child to the node's parent.
 * 3) If Node has two child?
 *        Find the minimum value in the right subtree of the current node.
 *        Replace the current node's value with the minimum value.
 *        Delete the node containing the minimum value from the right subtree.
 *
 */