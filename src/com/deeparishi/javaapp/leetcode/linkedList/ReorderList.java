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

        reorderList(head);
    }

    public static void reorderList(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node firstpart = head;
        Node secondPart = reverse(slow);
        slow.next = null;

        Node tempA = head;
        Node tempB = secondPart;

        while (secondPart != null){

            tempA = firstpart.next;
            tempB = secondPart.next;

            firstpart.next = secondPart;
            secondPart.next = tempA;
            firstpart = tempA;
            secondPart = tempB;
        }

    }

    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }
}
