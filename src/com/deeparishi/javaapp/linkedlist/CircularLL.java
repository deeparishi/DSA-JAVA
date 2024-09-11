package com.deeparishi.javaapp.linkedlist;

public class CircularLL<T> {
    Node last;

    class Node {
        T data;
        Node next;

        Node(T val) {
            data = val;
        }
    }

    CircularLL() {
        last = null;

    }

    public void InsertBegin(T val) {
        Node newnode = new Node(val);
        if (last == null) {
            newnode.next = newnode;
            last = newnode;
        }
        newnode.next = last.next;
        last.next = newnode;
    }

    public void display() {
        Node temp = last.next;
        do {
            System.out.println(temp.data);
            temp = temp.next;
        } while (temp != last.next);
    }
}
