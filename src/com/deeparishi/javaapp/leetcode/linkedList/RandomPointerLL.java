package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

public class RandomPointerLL {

    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {

        copyRandomNode(head);
        connectRandomPointer(head);
        return connectNextPointer(head);
    }

    private Node connectNextPointer(Node head) {
        Node temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;
        while (temp != null){
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    private void copyRandomNode(Node head) {
        Node temp = head;
        while (temp != null){
            Node copyNode = new Node(temp.value);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
    }

    private void connectRandomPointer(Node head) {
        Node temp = head;
        while (temp != null){
            Node copyNode = temp.next;
            if(temp.random != null)
                copyNode.random = temp.random.next;
            temp = temp.next.next;
        }
    }
}
