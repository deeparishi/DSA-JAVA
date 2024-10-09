package com.deeparishi.javaapp.old.bst;

public class MainClassForBT {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(10);

        binaryTree.insertLeft(binaryTree.root, 5); // Left child
        binaryTree.insertRight(binaryTree.root, 15); // Right child
        binaryTree.insertLeft(binaryTree.root.left, 3); // Left subtree
        binaryTree.insertRight(binaryTree.root.left, 8); // Right subtree (corrected to be child of node 5)
        binaryTree.insertLeft(binaryTree.root.right, 12); // Left child of node 15

        System.out.println("In-order traversal:");
        binaryTree.inOrder(binaryTree.root);

        System.out.println("\nPre-order traversal:");
        binaryTree.preOrder(binaryTree.root);

        System.out.println("\nPost-order traversal:");
        binaryTree.postOrder(binaryTree.root);
    }
}
