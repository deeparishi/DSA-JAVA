package com.deeparishi.javaapp.leetcode.stack;

public class CircularQueue {

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);  // return True
        myCircularDeque.insertLast(2);  // return True
        myCircularDeque.insertFront(3); // return True
        myCircularDeque.insertFront(4); // return False, the queue is full.
        myCircularDeque.getRear();      // return 2
        myCircularDeque.isFull();       // return True
        myCircularDeque.deleteLast();   // return True
        myCircularDeque.insertFront(4); // return True
        myCircularDeque.getFront();     // return 4
    }
}

class MyCircularDeque {

    final int[] QUEUE;
    final int CAPACITY;
    int front;
    int rear;
    int size;

    public MyCircularDeque(int k) {
        QUEUE = new int[k];
        CAPACITY = k;
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;

        if(isEmpty()) rear = front = 0;

        else {
            front = (front - 1 + CAPACITY) % CAPACITY;
        }
        QUEUE[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;

        if(isEmpty()) rear = front = 0;

        else {
            rear = (rear + 1) % CAPACITY;
        }
        QUEUE[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isFull()) return false;

        if(front == rear) rear = front = -1;

        else {
            front = (front + 1 ) % CAPACITY;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isFull()) return false;

        if(front == rear) rear = front = -1;

        else {
            rear = (rear - 1 + CAPACITY) % CAPACITY;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return QUEUE[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return QUEUE[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return CAPACITY == size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
