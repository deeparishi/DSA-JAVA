package com.deeparishi.javaapp.leetcode.stack;

//https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5132866#questions

import java.util.Stack;

public class StackMinimum {

    public static void main(String[] args) {
        StackMin min = new StackMin();
        min.push(5);
        min.push(4);
        min.push(1);
        min.push(2);
        min.push(15);

        System.out.println(min.min());
        min.pop();
        min.pop();
        System.out.println(min.min());


    }

}

class StackMin {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;


    public StackMin() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public int min() {
        if (mainStack.isEmpty())
            return  -1;
        return minStack.peek();
    }

    public void push(int value) {
        mainStack.push(value);
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public int pop() {
        if (mainStack.isEmpty())
            return  -1;
        int poppedValue = mainStack.pop();
        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
        return poppedValue;
    }
}