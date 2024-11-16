package com.deeparishi.javaapp.dsaconcepts.tree.bst;

public class MainClass {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(1);
//        System.out.println(bst.insert(0));
//        System.out.println(bst.insert(4));
//        System.out.println(bst.insert(6));
//        System.out.println(bst.insert(5));
//        System.out.println();

        bst.preOrder();
        System.out.println();
        bst.delete(1);
        bst.preOrder();
    }
}
