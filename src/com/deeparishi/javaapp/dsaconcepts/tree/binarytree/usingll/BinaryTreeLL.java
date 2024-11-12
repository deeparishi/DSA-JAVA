package com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingll;

public class BinaryTreeLL {

    BinaryTreeNode node;

    BinaryTreeLL(){
        this.node = null;
    }


    void preOrder(BinaryTreeNode node){
        if(node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void inOrder(BinaryTreeNode node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    void postOrder(BinaryTreeNode node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}
