package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;


class RemoveNthNode {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        Node n = removeNthFromEndNew(node, 5);


    }

    public static Node removeNthFromEnd(Node head, int n) {

        if(head == null || (head.next == null && n >= 1))
            return null;

        int size = 1;
        Node temp = head;

        while (temp != null){
            size++;
            temp = temp.next;
        }

        if( n > size)
            return null;

        Node fromEnd = reverse(head);

        int ind = 1;

        while (fromEnd.next != null){
            if(ind == n){
                fromEnd.next = fromEnd.next.next;
                break;
            }
            fromEnd = fromEnd.next;
        }

        return reverse(fromEnd);
    }

    public static Node reverse(Node node){

        Node curr = node;
        Node prev = null;
        Node next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        node = prev;
        return node;
    }

    public static Node removeNthFromEndNew(Node head, int n) {

        if (head == null) return null;

        // Create a dummy node to handle edge cases such as removing the first node
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        // Move fast pointer n+1 steps ahead so that when fast reaches the end, slow is at the node before the target
        for (int i = 0; i <= n; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                // If n is greater than the number of nodes, return null
                return null;
            }
        }

        // Move both slow and fast pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Now, slow is at the node before the target node. Remove the nth node.
        slow.next = slow.next.next;

        // Return the head of the modified list
        return dummy.next;
    }

}
