package com.deeparishi.javaapp.leetcode.recursion;

import java.util.Stack;

//https://www.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1?page=1&category=Recursion&sortBy=submissions


public class DeleteMidOfStack {

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
//        st.push(50);
        deleteMid(st, st.size());
        System.out.println(st);
    }

    static void deleteMid(Stack<Integer> s, int sizeOfStack) {
        deleteMiddleElement(s, sizeOfStack, 0);
    }

    private static void deleteMiddleElement(Stack<Integer> s, int sizeOfStack, int cuurent) {

        if(sizeOfStack / 2 == cuurent){
            s.pop();
            return;
        }

        int top = s.pop();
        deleteMiddleElement(s,sizeOfStack, cuurent + 1);
        s.push(top);

    }
}
