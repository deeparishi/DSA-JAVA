package com.deeparishi.javaapp.leetcode.recursion;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

//https://www.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1?page=1&category=Linked%20List&sortBy=submissions

public class RemoveDuplicates {

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(2);
        l1.next.next = new Node(4);
        l1.next.next.next = new Node(5);
        Node res = removeDuplicates(l1);
        Node.printList(res);
    }

    static Node removeDuplicates(Node head) {

        if(head == null) return null;

        head.next = removeDuplicates(head.next);

        if(head.next != null) {
            if (head.value == head.next.value)
                return head.next;
        }
        return head;
    }
}
