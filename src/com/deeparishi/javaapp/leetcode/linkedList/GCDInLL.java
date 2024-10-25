package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

class GCDInLL {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(6);
        node.next.next = new Node(10);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(9);

        insertGreatestCommonDivisors(node);

    }

    static Node insertGreatestCommonDivisors(Node head) {

        if(head == null || head.next == null)
            return head;

        Node prev = head;
        Node curr = head.next;

        while (curr != null){
            Node node = new Node(findGCD(prev.value, curr.value));
            node.next = curr;
            prev.next = node;

            curr = curr.next;
            prev = prev.next.next;
        }

        return head;
    }

    static int findGCD(int a, int b){
        int result = Math.min(a, b);
        while (result != 0){
            if(a % result == 0 && b % result == 0){
                break;
            }
            result--;
        }
        return result;
    }
}
