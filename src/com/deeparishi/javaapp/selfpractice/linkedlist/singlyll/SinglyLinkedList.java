package com.deeparishi.javaapp.selfpractice.linkedlist.singlyll;


import com.deeparishi.javaapp.selfpractice.linkedlist.node.Node;

public class SinglyLinkedList {

    Node head;

    Node tail;

    int size;

    SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public int insertAtBeginning(int value) {

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

    public int insert(int value) {

        if (head == null) {
            return insertAtBeginning(value);
        }

        Node node = new Node();
        node.value = value;

        tail.next = node;
        node.next = null;
        tail = node;
        size++;

        return node.value;
    }

    public int insertAt(int index, int value) {

        if (index < 0)
            throw new ArrayIndexOutOfBoundsException();

        if (index == 0)
            return insertAtBeginning(value);


        if (index == size + 1) {
            return insert(value);
        } else if (index > size) {
            return 0;
        } else {

            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            Node node = new Node();
            node.value = value;
            node.next = temp.next;
            temp.next = node;
            return node.value;
        }
    }

    public int insertNear(int nearValue, int value) {

        if (head == null)
            return insertAtBeginning(value);

        Node temp = head;

        for (int i = 0; i < size; i++) {
            if (temp.value == nearValue) {
                break;
            }
            temp = temp.next;
        }

        if (temp.value != nearValue)
            return 0;

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
            return;
        }

        Node node = head;

        for (int i = 0; i < size - 2; i++) {
            node = node.next;
        }

        node.next = null;
        tail = node;
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

        if (index == 0) {
            head.value = value;
            return true;
        }

        if (index > size) {
            return false;
        }

        Node temp = head;
        Node prev = null;

        for (int i = 0; i <= index; i++) {
            if (i == index) {
                temp.value = value;


            }
            prev = temp;
            temp = temp.next;
        }

        return true;

    }

    public boolean remove(int index) {

        if (index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            head = head.next;
            size--;
            if (size == 0)
                tail = null;
            return true;
        } else if (index == size - 1) {

            Node tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }

            tempNode.next = null;
            tail = tempNode;
            size--;
            return true;
        } else {

            Node tempNode = head;
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.next;
            }

            tempNode.next = tempNode.next.next;
            size--;
            return true;
        }
    }

    public boolean removeByValue(int value) {

        int index = 0;
        Node temp = head;

        while (temp != null) {
            if (temp.value == value) {
                break;
            } else {
                temp = temp.next;
                index++;
            }
        }

        return remove(index);
    }

    //Brut-Force Approach
    public Node reverse(){

        int size = 0;
        Node temp = head;

        while (temp != null){
            temp = temp.next;
            size++;
        }

        int[] arr = new int[size];
        Node build = head;

        for(int i = 0; i < size; i++){
            arr[i] = build.value;
            build = build.next;
        }

        Node newNode = head;

        for(int i = size -1; i >= 0; i--){
            newNode.value = arr[i];
            newNode = newNode.next;
        }

        return newNode;

    }

    //Optimal Approach
    public Node reverseOptimal(){

        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }

        return prev;
    }

    public void deleteSinglyLinkedList(){
        if(head == null){
            return;
        }

        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

}
