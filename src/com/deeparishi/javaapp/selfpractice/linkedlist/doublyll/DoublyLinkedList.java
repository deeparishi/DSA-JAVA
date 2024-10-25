package com.deeparishi.javaapp.selfpractice.linkedlist.doublyll;

import com.deeparishi.javaapp.selfpractice.linkedlist.node.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    public boolean delete(T value){

        if(head == null)
            return false;

        Node temp = head;
        int index = 0;

        while (temp != null  && temp.value != value){
            index++;
            temp = temp.next;
        }
        return deleteAt(index);
    }

    public boolean deleteAt(int index) {

        if(head == null)
            return false;

        if(index > size)
            return false;

        if(index == 0){
            if(head == tail){
                head = null;
                tail = null;
                size--;
                return true;
            }

            head = head.next;
            head.prev = null;
            size--;
            return true;
        } else if(index == size - 1){
            Node prev = tail.prev;
            tail.prev.next = null;
            tail = prev;
            size--;
            return true;
        }else{
            Node temp = head;
            int location = 0;
            while (location < index - 1){
                location++;
                temp = temp.next;
            }

            temp.next = temp.next.next;
            temp.next.prev = temp;
            size--;
            return true;
        }
    }

    public boolean deleteEntireList(){

        if(head == null)
            return false;

        Node temp = head;

        while(temp != null){
            temp.prev = null;
            temp = temp.next;
        }

        head = null;
        tail = null;

        return true;
    }

    public void print(){

        Node forward = head;

        System.out.println(" Forward....");
        while (forward != null){
            System.out.println(STR."\{forward.value} -> ");
            forward = forward.next;
        }
    }

    public Node mergeSorted(Node a1, Node b1){

        Node a = a1;

        Node head = null;
        Node tail = null;

        while(a != null){
            Node node = new Node();
            node.value = a.value;
            if(head == null){
                head = node;
                tail = node;
            }else{
                tail.next = node;
                tail = node;
            }
        }

        Node b = b1;
        Node temp = head;

        while(b != null){

            Node node = new Node();
            node.value = b.value;
        }
        return null;
    }


    @SuppressWarnings("unchecked")
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                if (temp == null) {
                    throw new NoSuchElementException();
                }
                T value = temp.value;
                temp = temp.next;
                return value;
            }
        };
    }

}
