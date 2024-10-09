package com.deeparishi.javaapp.old.bst;

public class MainClassForBST {

    public static void main(String[] args) {

//        System.out.println("\n\n\n First Object");
//
//        BinarySearchTree bst = new BinarySearchTree();
//
//        bst.insert(10);
//        bst.insert(120);
//        bst.insert(11230);
//        bst.insert(1210);
//        bst.insert(1110);
//
//        System.out.println(STR."Search the given value -> \{bst.search(bst.root, 120)}");
//
//        System.out.println("Before deletion");
//        bst.print();
//
//        System.out.println("\n\n\nAfter deletion");
//        bst.delete(1210);
//        bst.print();


        System.out.println("\n\n\n Next Object");

        BinarySearchTree bstNew = new BinarySearchTree(90);

        bstNew.insert(1);
        bstNew.insert(45);
        bstNew.insert(22);
        bstNew.insert(67);
        bstNew.insert(17);
        bstNew.insert(17);
        bstNew.insert(170);
        bstNew.insert(150);
        bstNew.insert(78);
        bstNew.insert(200);
        bstNew.insert(25);
        bstNew.insert(-1);

        System.out.println(STR."Search the given value -> \{bstNew.search(bstNew.root, 45)}");

        System.out.println("Before deletion");
        bstNew.print();

        System.out.println("\n\n\nAfter deletion");
        bstNew.delete(45);
        bstNew.print();

    }
}
