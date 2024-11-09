package com.deeparishi.javaapp.dsaconcepts.queue.usingarray;

public class Queue {
    private final int[] QUEUE;
    private int beginning;
    private int top;
    private final int CAPACITY;

    public Queue() {
        CAPACITY = 6;
        QUEUE = new int[CAPACITY];
        beginning = 0;
        top = 0;
    }

    public Queue(int size) {
        CAPACITY = size;
        QUEUE = new int[CAPACITY];
        beginning = 0;
        top = 0;
    }

    public int enqueue(int val) {
        if (isFull()) {
            return -1;
        }
        QUEUE[top] = val;
        top = (top + 1) % CAPACITY;
        return val;
    }

    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int value = QUEUE[beginning];
        beginning = (beginning + 1) % CAPACITY;
        return value;
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return QUEUE[(top - 1 + CAPACITY) % CAPACITY];
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return QUEUE[beginning];
    }

    public boolean isEmpty() {
        return beginning == top;
    }

    public boolean isFull() {
        return (top + 1) % CAPACITY == beginning;
    }

    public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.println(QUEUE[(beginning + i) % CAPACITY]);
        }
    }

    public int size() {
        return (top - beginning + CAPACITY) % CAPACITY;
    }
}
