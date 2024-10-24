package com.deeparishi.javaapp.leetcode.stack;

//https://leetcode.com/problems/implement-queue-using-stacks/?envType=problem-list-v2&envId=queue

import java.util.Stack;

public class QueueUsingStack {

    public static void main(String[] args) {

    }


}
class MyQueue {

    Stack<Integer> stackInput;
    Stack<Integer> stackOutput;
    public MyQueue() {
        stackInput = new Stack<>();
        stackOutput = new Stack<>();
    }

    public void push(int x) {
       stackInput.push(x);
    }

    public int pop() {
        if (!stackOutput.isEmpty())
            return stackOutput.pop();
        else {
            while (!stackInput.isEmpty()){
                stackOutput.push(stackInput.pop());
            }
        }
        return stackOutput.pop();
    }

    public int peek() {
        if (!stackOutput.isEmpty())
            return stackOutput.peek();
        else {
            while (!stackInput.isEmpty()){
                stackOutput.push(stackInput.pop());
            }
        }
        return stackOutput.peek();
    }

    public boolean empty() {
        return stackInput.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */