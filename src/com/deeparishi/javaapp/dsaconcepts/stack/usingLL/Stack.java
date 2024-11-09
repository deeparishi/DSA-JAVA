package com.deeparishi.javaapp.dsaconcepts.stack.usingLL;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

public class Stack {

    Node head;

    int size;

    public Stack(){
        size = 0;
        head = null;
    }

    public Stack(int value){
        size = 0;
        head = new Node(value);
    }

    public void push(int value){
        if(head == null){
            head = new Node(value);
        }else{
            Node node = new Node(value);
            node.next = head;
            head = node;
        }
    }

    public int peek(){
        if (head == null)
            return -1;
        return head.value;
    }

    public int pop(){
        if (head == null)
            return -1;
        int val =  head.value;
        if(head.next == null)
            head = null;
        else
            head = head.next;
        return val;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public boolean delete(){
        head = null;
        return true;
    }

    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.print(STR."\{temp.value} ");
            temp = temp.next;
        }
        System.out.println();
    }
}
