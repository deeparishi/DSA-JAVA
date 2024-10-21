package com.deeparishi.javaapp.leetcode;

import com.deeparishi.javaapp.leetcode.linkedList.utl.LinkedList;
import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

public class RemoveNthNode {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);

        Node temp = removeNthFromEnd(ll.head, 1);

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    static Node removeNthFromEnd(Node head, int n) {

        Node dummy = new Node();
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;

        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }
}
