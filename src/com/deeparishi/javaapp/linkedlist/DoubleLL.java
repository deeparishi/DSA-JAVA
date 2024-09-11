package com.deeparishi.javaapp.linkedlist;

public class DoubleLL<T> {
    Node Head;
    Node Tail;

    class Node {
        T val;
        Node prev;
        Node next;

        Node(T val) {
            this.val = val;
            prev = null;
            next = null;
        }
    }

    DoubleLL() {
        Head = null;
        Tail = null;
    }

    public void InsertBegin(T val) {
        Node newnode = new Node(val);
        if (Head == null) {
            Head = newnode;
            Tail = newnode;
        } else {
            Head.prev = newnode;
            newnode.next = Head;
            Head = newnode;
        }
    }

    public void display() {
        Node temp = Head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public void reverse() {
        Node temp = Tail;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.prev;
        }
    }

    public void InsertatPos(int pos, T val) {
        if (pos == 0) {
            InsertBegin(val);
            return;
        }
        Node newnode = new Node(val);
        Node temp = Head;
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            temp.next = newnode;
            newnode.prev = temp;
            Tail = newnode;
            return;
        }
        newnode.next = temp.next;
        newnode.prev = temp;
        temp.next.prev = newnode;
        temp.next = newnode;
    }

    public void add(T val) {
        Node newnode = new Node(val);
        Tail.next = newnode;
        newnode.prev = Tail;
        Tail = newnode;

    }

    public void deleteatPos(int pos) {

        if (pos == 0) {
            Head = Head.next;
            Head.prev = null;
            return;
        }

        Node temp = Head;
        for (int i = 1; i <= pos; i++) {
            temp = temp.next;
            if (temp == null) {
                throw new ArrayIndexOutOfBoundsException("Position not founded");
            }
        }
        if (temp.next == null) {
            Tail = temp.prev;
            Tail.next = null;
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

}
