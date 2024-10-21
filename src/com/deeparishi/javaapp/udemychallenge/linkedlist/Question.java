package com.deeparishi.javaapp.udemychallenge.linkedlist;

import java.util.Stack;

public class Question {

    public static void main(String[] args) {

        LinkedList ll1 = new LinkedList();
        ll1.insert(1);
        ll1.insert(2);
        ll1.insert(3);
        ll1.insert(4);
        ll1.insert(5);


        Node temp = reverseBetween(ll1.head,2, 4);
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

    static void reverse(LinkedList ll){

        Node prev = null;
        Node curr = ll.head;
        Node next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ll.head = prev;
    }

    static LinkedList sumLists(LinkedList a, LinkedList b){

        int firstValue = 0;
        int secondValue = 0;

        reverse(a);
        reverse(b);

        Node tempA = a.head;
        Node tempB = b.head;

        while (tempA != null){
            firstValue = (firstValue * 10) + tempA.value;
            tempA = tempA.next;
        }

        while (tempB != null){
            secondValue = (secondValue * 10) + tempB.value;
            tempB = tempB.next;
        }

        int sum = firstValue + secondValue;

        Node head = null;
        Node tail = null;
        int size = 0;

        while (sum != 0){
            int val = sum % 10;
            Node node = new Node();
            node.value = val;
            if(head == null){
                head = node;
                tail = node;
                size++;
            }else{
                tail.next = node;
                tail = node;
                size++;
            }
            sum /= 10;
        }

        LinkedList ll = new LinkedList();
        ll.head = head;
        ll.tail = tail;
        ll.size = size;

        return ll;
    }

    static Node reverse(Node node){

        if(node.next == null){
            return node;
        }

        Node newNode = reverse(node.next);
        Node front = node.next;
        front.next = node;
        node.next = null;

        return newNode;

    }

    boolean isPalindrome(Node head) {

        if(head == null)
            return false;

        if(head.next == null)
            return true;

        Node temp = head;
        Stack<Integer> st = new Stack<>();

        while (temp != null){
            st.push(temp.value);
            temp = temp.next;
        }

        Node temp2 = head;
        while (temp2 != null){
            if(temp2.value != st.pop()){
                return false;
            }
            temp2 = temp2.next;
        }

        return true;
    }

    static Node reverseBetween(Node head, int left, int right) {

        Node curr = head;
        int index = 1;
        Stack<Integer> st = new Stack<>();

        while (curr != null){
            if(index >= left && index <= right){
                st.push(curr.value);
            }
            index++;
            curr = curr.next;
        }

        curr = head;
        index = 1;

        while (curr != null){
            if(index >= left && index <= right){
                curr.value = st.pop();
            }
            curr = curr.next;
            index++;
        }

        return head;
    }
}

class LinkedList{
    Node head;
    Node tail;
    int size;

    public Object insertAtBeginning(int value) {
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

    public Object insert(int value) {
        if (head == null) {
            return insertAtBeginning(value);
        }

        Node node = new Node();
        node.value = value;
        tail.next = node;
        tail = node;
        size++;
        return node.value;
    }
}

class Node{

    public int value;

    public Node next;
}