package com.deeparishi.javaapp.selfpractice.linkedlist.doublyll;

import com.deeparishi.javaapp.selfpractice.linkedlist.node.Node;

import java.util.Iterator;

public class DoublyLinkedList <T> implements Iterable<T> {

    Node head;

    Node tail;

    int size;

    DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void insertAtBeginning(T value){

        if(head == null){
            Node node = new Node();
            node.value = value;
            node.prev = null;
            node.next = null;
            head = node;
            tail = node;
            size++;
        }
    }

    public void insert(T value){

        if(head == null){
            insertAtBeginning(value);
            return;
        }

        Node node = new Node();
        node.value = value;

        Node curr = head;

        while (curr.next != null){
            curr = curr.next;
        }

        curr.next = node;
        node.prev = curr;
        node.next = null;
        tail = node;
        size++;

    }

    public void insertAt(T value, int index){

        if(head == null && index == 0){
            insertAtBeginning(value);
            return;
        }

        if(head == null)
            return;

        if(index >= size){
            insert(value);
            return;
        }

        Node<T> node = new Node<>();
        node.value = value;

        if (index == 0) {
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            Node<T> curr = head;
            // Find the node at (index - 1) position
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }

            node.next = curr.next;
            node.prev = curr;
            if (curr.next != null) {
                curr.next.prev = node;
            }
            curr.next = node;
        }

        size++;
    }

    public void print(){

        Node forward = head;

        System.out.println(" Forward....");
        while (forward != null){
            System.out.println(STR."\{forward.value} -> ");
            forward = forward.next;
        }

        Node backward = tail;

        System.out.println(" Backward....");
        while (backward != null){
            System.out.println(STR."\{backward.value} -> ");
            backward = backward.prev;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
