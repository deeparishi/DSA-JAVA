package com.deeparishi.javaapp.dsaconcepts.linkedlist.singlyll;

import com.deeparishi.javaapp.dsaconcepts.linkedlist.node.Node;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class CircularSinglyLinkedList <T> implements Iterable<T> {

    private Node head;

    private Node tail;

    private int size;

    CircularSinglyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void insertAtBeginning(T value){

        Node node = new Node();
        node.value = value;

        if(head == null){
            node.next = node;
            head = node;
            tail = node;
            size++;
        } else{
            node.next = head;
            head = node;
            tail.next = node;
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
        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }

    public void insertAt(T value, int index) {

        if (index == 0) {
            insertAtBeginning(value);
            return;
        }

        if (index >= size) {
            insert(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node newNode = new Node();
        newNode.value = value;

        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }

    public boolean delete(T value){

        Node temp = head;
        int index = 0;

        while (temp.value != value && temp.next != head){
            temp = temp.next;
            index++;
        }

        if(index == size && temp.value != value)
            return false;

        return deleteAt(index);


    }

    public boolean deleteAt(int index) {

        if(index > size)
            return false;

        if(index == 0){
            if(head.next == head){
                tail.next = null;
                head = null;
                tail = null;
                size--;
                return true;
            }
            head = head.next;
            tail.next = head;
            size--;
            return true;
        }

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        if(temp.next == tail){
            tail = temp;
            tail.next = head;
            size--;
            return true;
        }

        temp.next = temp.next.next;
        size--;
        return true;
    }

    public boolean deleteByValue(int value) {

       if(head == null && size == 0)
           return false;

       if(this.head.equals(tail) && this.head.value.equals(value)){
           tail.next = null;
           head = null;
           tail = null;
           size--;
           return true;
       }

       Node curr = this.head;
       Node prev = null;

       do {
           if(curr.value.equals(value)){

               if(curr == this.head){
                   head = head.next;
                   tail.next = head;
               }else if(curr == this.tail){
                   prev.next = this.head;
                   this.tail = prev;
               }else{
                   prev.next = curr.next;
               }
               this.size--;
               return true;
           }

           prev = curr;
           curr = curr.next;
       }while (curr != this.head);

       return false;
    }
    public void print(){

        Node temp = head;

        for(int i=0; i<size; i++){
            System.out.print(STR."\{temp.value} -> ");
            temp = temp.next;
        }

    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            Node temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                temp = temp.next;
                return (T) temp;
            }
        };
    }
}
