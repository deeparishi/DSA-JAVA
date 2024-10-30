package com.deeparishi.javaapp.leetcode.stack;

public class DesignStack {

    public static void main(String[] args) {
        CustomStack stk = new CustomStack(3);
        stk.push(1);
        stk.push(2);
        System.out.println(stk.pop());
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.increment(5, 100);
        stk.increment(2, 100);
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());

    }

}

class CustomStack {

    private final int[] STACK;
    private final int MAX_SIZE;
    private int topOfStack;


    public CustomStack(int maxSize) {
        STACK = new int[maxSize];
        MAX_SIZE = maxSize;
        topOfStack = -1;
    }

    public void push(int x) {
        if (isFull()) return;

        STACK[++topOfStack] = x;
        return;
    }

    public int pop() {
        if (isEmpty()) return -1;

        int val = STACK[topOfStack];
        STACK[topOfStack] = 0;
        topOfStack--;
        return val;
    }

    public void increment(int k, int val) {
        if(k < STACK.length)
            k--;
        else
            k = STACK.length - 1;

        if(!isEmpty()){
            for (int i = 0; i <= k; i++) {
                STACK[i] = val + STACK[i];
            }
        }
    }

    private boolean isFull(){
        return topOfStack == STACK.length -1;
    }

    private boolean isEmpty(){
        return topOfStack == -1;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
