package com.deeparishi.javaapp.selfpractice.linkedlist.singlyll;

public class Question {

    public static void main(String[] args) {

        LinkedList ll1 = new LinkedList();
        ll1.insert(7);
        ll1.insert(1);
        ll1.insert(6);

        LinkedList ll2 = new LinkedList();
        ll2.insert(5);
        ll2.insert(9);
        ll2.insert(2);

        LinkedList ans = sumLists(ll1, ll2);
        Node temp = ans.head;
        for (int i = 0; i < ans.size; i++) {
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