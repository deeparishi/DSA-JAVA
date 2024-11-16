package com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingnode;

public class MainClass {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(4);

        binaryTree.preOrder();
    }
}
