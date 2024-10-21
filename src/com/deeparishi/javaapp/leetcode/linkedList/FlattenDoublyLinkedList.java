package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

public class FlattenDoublyLinkedList {


    public static void main(String[] args) {

        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        head.next = node2;
        node2.prev = head;

        node2.next = node3;
        node3.prev = node2;

        node3.next = node4;
        node4.prev = node3;

        node4.next = node5;
        node5.prev = node4;

        node5.next = node6;
        node6.prev = node5;

        // Level 2 (Child of node 3)
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        node3.child = node7;

        node7.next = node8;
        node8.prev = node7;

        node8.next = node9;
        node9.prev = node8;

        node9.next = node10;
        node10.prev = node9;

        // Level 3 (Child of node 8)
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        node8.child = node11;

        node11.next = node12;
        node12.prev = node11;

        // Printing the flattened list to check correctness
        Node temp = flatten(head);
        while (temp != null) {
            System.out.print(STR."\{temp.value} ");
            temp = temp.next;
        }
    }

    static Node flatten(Node head) {
        if( head == null)
            return head;

        // Pointer
        Node p = head;
        while( p!= null) {

            /* CASE 1: if no child, proceed */
            if( p.child == null ) {
                p = p.next;
                continue;
            }

            /* CASE 2: got child, find the tail of the child and link it to p.next */
            Node temp = p.child;
            // Find the tail of the child
            while( temp.next != null )
                temp = temp.next;

            // Connect tail with p.next, if it is not null
            temp.next = p.next;
            if( p.next != null )
                p.next.prev = temp;

            // Connect p with p.child, and remove p.child
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}
