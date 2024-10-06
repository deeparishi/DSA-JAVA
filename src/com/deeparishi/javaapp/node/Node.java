package com.deeparishi.javaapp.node;

public class Node {

    public int data;
    public Node left;
    public Node right;

    public int height;

    public Node(int d) {
        data = d;
        left = null;
        right = null;
    }

    public Node() {
        left = null;
        right = null;
    }

}
