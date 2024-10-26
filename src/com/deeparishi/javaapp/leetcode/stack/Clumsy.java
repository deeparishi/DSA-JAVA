package com.deeparishi.javaapp.leetcode.stack;

import java.util.Stack;

//https://leetcode.com/problems/clumsy-factorial/

public class Clumsy {

    public static void main(String[] args) {
        System.out.println(clumsy(4));
        System.out.println(clumsy(14));
    }

    static int clumsy(int n) {

        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        n--;

        int operation = 0;

        while (n > 0) {
            if (operation == 0) {
                stack.push(stack.pop() * n);
            } else if (operation == 1) {
                stack.push(stack.pop() / n);
            } else if (operation == 2) {
                stack.push(n);
            } else {
                stack.push(-n);
            }
            n--;
            operation = (operation + 1) % 4;
        }

        int result = 0;
        while (!stack.isEmpty())
            result += stack.pop();
        return result;
    }
}
