package com.deeparishi.javaapp.avl;

public class AVLMainClass {

    public static void main(String[] args) {

        AVL avl = new AVL();
        avl.insert(50);
        avl.insert(20);
        avl.insert(10);
        avl.insert(40);
        avl.insert(30);
        avl.insert(60);

        avl.print();
    }
}
