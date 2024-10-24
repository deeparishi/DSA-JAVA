package com.deeparishi.javaapp.selfpractice.queue.usingarray;

public class CircularQueue {

    private final int[] QUEUE;

    private int rear;

    private int front;

    private final int CAPACITY;

    CircularQueue() {
        QUEUE = new int[5];
        CAPACITY = 5;
        rear = -1;
        front = -1;
    }

    CircularQueue(int size) {
        QUEUE = new int[size];
        CAPACITY = size;
        rear = -1;
        front = -1;
    }

    public void enqueue(int val) {

        if (isFull()) return;

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % CAPACITY;
        }
        QUEUE[rear] = val;
    }

    public int  dequeue() {
        if (isEmpty()) return -1;
        int dequeuedValue = QUEUE[front];
        if (front == rear) front = rear = -1;
        else front = (front + 1) % CAPACITY;
        return dequeuedValue;
    }

    public int front(){
        return QUEUE[front];
    }

    public int rear(){
        return QUEUE[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return front == (rear + 1) % CAPACITY;
    }

    public void print() {
        int i = front;
        while (true) {
            System.out.println(QUEUE[i]);
            if (i == rear) break;
            i = (i + 1) % CAPACITY;
        }
    }

}
