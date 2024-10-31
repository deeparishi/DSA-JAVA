package com.deeparishi.javaapp.leetcode.recursion;

//https://leetcode.com/problems/count-collisions-of-monkeys-on-a-polygon/description/?envType=problem-list-v2&envId=recursion&difficulty=MEDIUM

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

public class RemoveGreaterNode {

    public static void main(String[] args) {
        Node l1 = new Node(5);
        l1.next = new Node(2);
        l1.next.next = new Node(13);
        l1.next.next.next = new Node(3);
        l1.next.next.next.next = new Node(8);
        Node res = removeNodesRecursive(l1);
        printList(res);
    }

    static Node removeNodes(Node head) {
        head = reverse(head);

        Node current = head;
        Node rightSide = head.next;

        while (current != null) {
            if (current.value < rightSide.value) {
                rightSide.next = current.next;
            } else {
                rightSide = current;
            }
            current = current.next;
        }

        return reverse(head);

    }

    static Node reverse(Node head) {

        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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

    static Node removeNodesRecursive(Node node) {

        if(node == null) return null;

        node.next = removeNodesRecursive(node.next);

        int max = Math.max(
                node.value, node.next != null ? node.next.value : Integer.MIN_VALUE
        );

        if(node.value < max) return node.next;
        else return node;
    }

}
