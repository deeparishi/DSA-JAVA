package com.deeparishi.javaapp.leetcode.linkedList.utl;

public class LinkedList {

    public Node head;
    public Node tail;
    int size;

    public Object insertAtBeginning(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            tail = node;
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
        return node.value;
    }

    public Object insert(int value) {
        if (head == null) {
            return insertAtBeginning(value);
        }

        Node node = new Node();
        node.value = value;
        tail.next = node;
        tail = node;
        size++;
        return node.value;
    }

}
