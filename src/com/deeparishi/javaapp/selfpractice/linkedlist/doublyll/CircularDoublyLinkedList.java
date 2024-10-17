package com.deeparishi.javaapp.selfpractice.linkedlist.doublyll;

import com.deeparishi.javaapp.selfpractice.linkedlist.node.Node;

import java.util.Iterator;

public class CircularDoublyLinkedList <T> implements Iterable<T> {

    Node head;

    Node tail;

    int size;

    public void insertAtBeginning(T value){

        Node node = new Node();
        node.value = value;

        if(head == null){
            head = node;
            head.prev = tail;
            tail = node;
            tail.next = head;
            size++;
        }else{
            head.prev = node;
            node.next = head;
            node.prev = tail;
            tail.next = node;
            head = node;
            size++;
        }
    }

    public void insert (T value){

        Node node = new Node();
        node.value = value;

        if(head == null){
            insertAtBeginning(value);
            return;
        }

        tail.next = node;
        node.prev = tail;
        node.next = head;
        head.prev = node;
        tail = node;
        size++;
    }

    public void print(){

        Node temp = head;

       while (head != temp.next){
            System.out.print(STR."\{temp.value} -> ");
            temp = temp.next;
        }
        System.out.print(temp.value);
        System.out.println();

       Node rev = tail;
        do {
            System.out.print(STR."\{rev.value} -> ");
            rev = rev.prev;
        } while (rev != tail);
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
