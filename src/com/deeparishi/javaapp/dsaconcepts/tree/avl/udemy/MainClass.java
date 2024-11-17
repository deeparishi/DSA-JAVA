package com.deeparishi.javaapp.dsaconcepts.tree.avl.udemy;

public class MainClass {

    public static void main(String[] args) {

        AVL avl = new AVL();

        avl.insert(10);
        avl.insert(9);
        avl.insert(8);
        avl.insert(6);
        avl.insert(7);
        avl.insert(3);
        avl.insert(4);
        avl.insert(12);
        avl.insert(11);
        avl.insert(14);
        avl.insert(15);

        System.out.println();
        avl.preOrder();
        System.out.println();
        avl.delete(7);
        avl.preOrder();
    }
}
