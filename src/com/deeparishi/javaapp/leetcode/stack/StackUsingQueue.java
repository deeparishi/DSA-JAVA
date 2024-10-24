package com.deeparishi.javaapp.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/implement-stack-using-queues/?envType=problem-list-v2&envId=queue

public class StackUsingQueue {
    public static void main(String[] args) {

    }
}
class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.peek());
            queue.poll();
        }
    }

    public int pop() {
        if (queue.isEmpty()) return -1;
        return queue.poll();
    }

    public int top() {
        if (queue.isEmpty()) return -1;
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */