package com.deeparishi.javaapp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/min-stack/submissions/1394501964/

class MinStack {

   List<Integer> stack;

    public MinStack() {
        this.stack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
    }

    public void pop() {
        if(!stack.isEmpty())
            stack.removeLast();
    }

    public int top() {
       return stack.isEmpty() ? -1 : stack.getLast();
    }

    public int getMin() {
        List<Integer> min = stack;
        Collections.sort(min);
        return min.getFirst();
    }
}

class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}

