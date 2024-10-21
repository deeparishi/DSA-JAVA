package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.LinkedList;
import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

public class RotateLinkedList {

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);

        Node temp = rotateList(ll.head, 13);

        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

    static Node rotateList(Node head, int k){

        int len = 1;
        Node tail = head;

        while (tail.next != null){
            tail = tail.next;
            len++;
        }

        if(k % len == 0) return head;

        k %= len;

        tail.next = head;
        Node newNode = findNthNode(head, len - k);
        head = newNode.next;
        newNode.next = null;

        return head;

    }

    static Node findNthNode(Node head, int i) {
        int cnt = 1;
        while (head != null){
            if (cnt == i)
                return head;
            head = head.next;
            cnt++;
        }
        return head;
    }
}
