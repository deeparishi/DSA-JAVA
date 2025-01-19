package com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingarray;

public class Main {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(8);
        binaryTree.insert("N1");
        binaryTree.insert("N2");
        binaryTree.insert("N3");
        binaryTree.insert("N4");
        binaryTree.insert("N5");
        binaryTree.insert("N6");
        binaryTree.insert("N7");
        System.out.println();
        binaryTree.preOrder(3);
        System.out.println();
        binaryTree.inOrder(1);
        System.out.println();
        binaryTree.postOrder(1);
        System.out.println();
        binaryTree.levelOrder();
        System.out.println();
        System.out.println(binaryTree.search("N12"));
        printAfterDeletion(binaryTree);

    }

    private static void printAfterDeletion(BinaryTree binaryTree) {
        System.out.println();
        System.out.println(binaryTree.delete("N1"));
        System.out.println("After Deletion....");
        System.out.println();
        binaryTree.preOrder(1);
        System.out.println();
        binaryTree.inOrder(1);
        System.out.println();
        binaryTree.postOrder(1);
        System.out.println();
        binaryTree.levelOrder();
        System.out.println();
    }
}
