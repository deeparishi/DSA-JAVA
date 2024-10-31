package com.deeparishi.javaapp.leetcode.linkedList.utl;

public class Node {

    public int value;

    public Node next;

    public Node child;

    public Node prev;

    public Node random;

    public int key;

    public  Node(){

    }
    public Node (int val){
        this.value = val;
    }

    public Node(int key, int val){
        this.key = key;
        this.value = val;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.value);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

//    Node(int val, Node next) { this.value = val; this.next = next; }

}
