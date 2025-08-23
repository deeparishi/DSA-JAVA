package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

//https://leetcode.com/problems/reorder-list/?envType=problem-list-v2&envId=linked-list

public class ReorderList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        ReorderList lr = new ReorderList();
        lr.reorderList(head);
    }

    Node left;
    boolean stop;
    public void reorderList(Node head) {
        left = head;
        this.stop = false;
        reorder(head);
    }

    public void reorder(Node right){
        if(right == null) return;

        reorder(right.next);

        if(!stop){
            Node temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;
        }

        if(left != null && left.next == right){
            left.next = null;
            stop = true;
        }
    }
}
