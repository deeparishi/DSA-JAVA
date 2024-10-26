package com.deeparishi.javaapp.selfpractice.queue.usingLL;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

public class Queue {

     Node head;

     Node tail;

     int size;

     public Queue(){
         head = null;
         tail = null;
         size = 0;
     }

     public void enqueue(int val){
         Node node = new Node(val);
         if(head == null)
             head = tail = node;
         else {
             tail.next = node;
             tail = node;
         }
     }

     public int dequeue(){
         if (head == null)
             return -1;
         int val = head.value;
         head = head.next;
         return val;
     }

     public int peek(){
         return head == null ? -1 : head.value;
     }

     public boolean isEmpty(){
         return head == null && tail == null;
     }

     public boolean delete(){
         if(head == null) return false;

         head = null;
         tail = null;
         return true;
     }
}
