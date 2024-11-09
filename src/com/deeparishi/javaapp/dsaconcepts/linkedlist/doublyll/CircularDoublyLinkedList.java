package com.deeparishi.javaapp.dsaconcepts.linkedlist.doublyll;

import com.deeparishi.javaapp.dsaconcepts.linkedlist.node.Node;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

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

    public void insert(int index, T value) {

        if (head == null || index == 0) {
            insertAtBeginning(value);
            return;
        }

        Node newNode = new Node();
        newNode.value = value;

        if(index >= size - 1) {
            newNode.prev = tail;
            newNode.next = tail.next;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
            size++;
        }else{

            Node curr = head;

            for(int i = 0; i < index - 1; i++){
                curr = curr.next;
            }

            newNode.prev = curr;
            newNode.next = curr.next;
            curr.next.prev = newNode;
            curr.next = newNode;
            size++;
        }
    }

    public boolean delete(T value){

        if (head == null)
            return false;

        Node temp = head;
        int index = 0;

        while (temp.next != head && !temp.value.equals(value)){
            index++;
            temp = temp.next;
        }

        if(temp.value.equals(value)){
            return deleteAt(index);
        }
        return false;
    }

    public boolean deleteAt(int index) {

        if(index > size)
            return false;

        if (index == 0) {
            head.next.prev = tail;
            tail.next = head.next;
            head.prev = null;
            head = head.next;
            size--;
            return true;
        } else if (index == size - 1) {
            tail.prev.next = head;
            head.prev = tail.prev;
            tail = tail.prev;
            size--;
            return true;
        } else {

            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next.next.prev = curr;
            curr.next = curr.next.next;
            size--;
            return true;
        }
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

    public Set<T> removeDuplicates(){

        Set<T> uniqueData = new LinkedHashSet<>();

        Node temp = head;
        Node prev = null;

        do {
            if (uniqueData.contains(temp.value)) {
                prev.next = temp.next;
                temp.next.prev = prev;
            } else {
                uniqueData.add((T) temp.value);
                prev = temp;
            }
            temp = temp.next;
        } while (temp != head);

        return uniqueData;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
