package com.deeparishi.javaapp.linkedlist;

import org.w3c.dom.Node;

public class LL {
    Node head;
    Node tail;

    class Node {
        int data;
        Node address;

        Node(int val) {
            this.data = val;
            address = null;
        }
    }

    LL() {
        head = null;
    }

    public void begin(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            newNode.address = head;
            head = newNode;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.address;
        }
    }

    public void insert(int pos, int val) {
        if (pos == 0) {
            begin(val);
            return;
        }
        Node newNode = new Node(val);
        Node temp = head;
        for (int i = 1; i < pos; i++) {
            temp = temp.address;
        }
        newNode.address = temp.address;
        temp.address = newNode;
    }

    public void delete(int pos) {
        if (head == null) {
            throw new IllegalArgumentException();
        }
        if (pos == 0) {
            head = head.address;
            return;
        }
        Node temp = head;
        Node prev = null;
        for (int i = 1; i <= pos; i++) {
            prev = temp;
            temp = temp.address;
        }
        prev.address = temp.address;

    }

    public void grtval(int pos) {
        if (pos == 0) {
            System.out.println(head.data);
            return;
        }
        Node temp = head.address;
        int value = 0;
        for (int i = 1; i <= pos; i++) {
            if (pos == i) {
                System.out.println(temp.data);
                break;
            }
            if (temp.address == null) {
                throw new IllegalArgumentException("Enter correct pos");
            }
            temp = temp.address;
        }

    }

    public void update(int pos, int val) {
        Node temp = head.address;

        for (int i = 1; i <= pos; i++) {
            if (i == pos) {
                temp.data = val;
            }
            temp = temp.address;
        }
    }

    public void deleteAtEnd() {
        Node temp = head.address;
        Node prev = null;
        while (temp.address != null) {
            prev = temp;
            temp = temp.address;
        }
        if (temp.address == null) {
            prev.address = null;

        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = head.address;
        while (current != null) {
            next = current.address;
            current.address = prev;
            prev = current;
            current = next;

        }
        head = prev;
    }

    public void InsertAtEnd(int val) {
        Node newnode = new Node(val);
        Node temp = head.address;
        while (temp.address != null) {
            temp = temp.address;
        }
        if (temp.address == null) {
            temp.address = newnode.address;
            newnode.data = val;
        }
    }

    public void remove(int pos, int val) {
        head = RemoveRec(val, pos, head);
    }

    public Node RemoveRec(int val, int pos, Node node) {
        if (pos == 0) {
            Node temp = new Node(val);
            return temp;
        }
        node.address = RemoveRec(val, pos--, node);
        return node;
    }
}


