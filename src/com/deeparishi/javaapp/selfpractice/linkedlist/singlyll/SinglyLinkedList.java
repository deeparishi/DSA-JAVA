package com.deeparishi.javaapp.selfpractice.linkedlist.singlyll;

import com.deeparishi.javaapp.selfpractice.linkedlist.node.Node;
import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {

    Node head;
    Node tail;
    int size;

    SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public Object insertAtBeginning(T value) {
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

    public Object insert(T value) {
        if (head == null) {
            return insertAtBeginning(value);
        }

        Node<T>  node = new Node();
        node.value = value;
        tail.next = node;
        tail = node;
        size++;
        return node.value;
    }

    public Object insertAt(int index, T value) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (index == 0) {
            return insertAtBeginning(value);
        }

        if (index == size) {
            return insert(value);
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node node = new Node();
        node.value = value;
        node.next = temp.next;
        temp.next = node;
        size++;
        return node.value;
    }

    public Object insertNear(int nearValue, T value) {
        if (head == null) {
            return insertAtBeginning(value);
        }

        Node temp = head;
        while (temp != null && !temp.value.equals(nearValue)) {
            temp = temp.next;
        }

        if (temp == null || !temp.value.equals(nearValue)) {
            return 0; // Value not found
        }

        Node node = new Node();
        node.value = value;
        node.next = temp.next;
        temp.next = node;
        size++;
        return node.value;
    }

    public void pop() {
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;
        size--;
    }

    public String rotate(int rotation) {
        if (head == null || rotation >= size || rotation < 0) {
            return "Failed";
        }

        Node current = head;
        Node prev = null;

        for (int i = 0; i < rotation; i++) {
            prev = current;
            current = current.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        Node last = current;
        while (last.next != null) {
            last = last.next;
        }

        last.next = head;
        head = current;

        return "Success";
    }

    public boolean set(int index, int value) {
        if (index < 0 || index >= size) {
            return false;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.value = value;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return true;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        if (index == size - 1) {
            tail = temp;
        }

        size--;
        return true;
    }

    public boolean removeByValue(T value) {
        Node temp = head;
        int index = 0;
        while (temp != null && !temp.value.equals(value)) {
            temp = temp.next;
            index++;
        }

        if (temp == null) {
            return false; // Value not found
        }

        return remove(index);
    }

    public Node reverseOptimal() {
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

    public boolean isListInLoop() {
        if (head == null) {
            return false;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T value = (T) temp.value;
                temp = temp.next;
                return value;
            }
        };
    }
}
