package com.deeparishi.javaapp.leetcode.stack;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> newStack = new Stack<>();
//        newStack.push(3);
//        newStack.push(2);
//        newStack.push(1);
//        newStack.push(7);
//        newStack.push(6);

        newStack.push(4);
        newStack.push(3);
        newStack.push(9);
        newStack.push(6);


        reverse(newStack);
        while (!newStack.isEmpty())
            System.out.println(newStack.pop());
    }
    static void reverse(Stack<Integer> s)
    {
        Stack<Integer> newStack = new Stack<>();

        while(!s.isEmpty()){
            newStack.push(s.pop());
        }

        while(!newStack.isEmpty()){
            s.push(newStack.pop());
        }
    }
}
