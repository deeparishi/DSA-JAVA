package com.deeparishi.javaapp.selfpractice.queue.usingarray;

public class Main {

    public static void main(String[] args) {

//        Queue queue = new Queue(10);
//
//        for (int i = 0; i <= 0; i++) queue.enqueue(i);
//
//        queue.print();
//
//        System.out.println(STR."Peek Element \{queue.peek()}");
//        System.out.println(STR."Top Element \{queue.top()}");
//        System.out.println(STR."Is Empty? \{queue.isEmpty()}");
//        System.out.println(STR."Is Full? \{queue.isFull()}");
//
//
//        System.out.println(STR."Remove the First element - DeQueue \{queue.dequeue()}");
//        queue.print();
//        System.out.println(STR."Peek Element \{queue.peek()}");
//        System.out.println(STR."Top Element \{queue.top()}");
//        System.out.println(STR."Is Empty? \{queue.isEmpty()}");
//        System.out.println(STR."Is Full? \{queue.isFull()}");


        CircularQueue cq = new CircularQueue(12);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        System.out.println(STR."Is Full \{cq.isFull()}");
        System.out.println(STR."Is Empty \{cq.isEmpty()}");
        cq.enqueue(4);
        cq.enqueue(5);
        System.out.println(STR."Is Full \{cq.isFull()}");
        System.out.println(STR."Is Empty \{cq.isEmpty()}");
        System.out.println(STR."Is Front \{cq.front()}");
        System.out.println(STR."Is Rear \{cq.rear()}");
        cq.print();
        System.out.println();
        System.out.println();
        cq.dequeue();
        cq.dequeue();
        System.out.println(STR."Is Full \{cq.isFull()}");
        System.out.println(STR."Is Empty \{cq.isEmpty()}");
        cq.print();
        System.out.println();
        cq.enqueue(6);
        cq.enqueue(7);
        System.out.println(STR."Is Full \{cq.isFull()}");
        System.out.println(STR."Is Empty \{cq.isEmpty()}");
        System.out.println(STR."Is Front \{cq.front()}");
        System.out.println(STR."Is Rear \{cq.rear()}");
        cq.print();
    }
}
