package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

public class DetectLoop {

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(2);
        l1.next.next = new Node(4);
        l1.next.next.next = new Node(5);
        l1.next.next.next.next = l1;

        System.out.println(detectLoop(l1));

    }

    public static boolean detectLoop(Node head) {

        Node fast = head.next;
        Node slow = head;

        while (fast != null && fast.next != null){

            if(fast == slow) return true;

            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
