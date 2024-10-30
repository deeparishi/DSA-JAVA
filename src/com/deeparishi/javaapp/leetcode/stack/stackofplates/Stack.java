package com.deeparishi.javaapp.leetcode.stack.stackofplates;

import java.util.EmptyStackException;

public class Stack {

    private int capacity;

    private int size;

    private StackNode top;

    private StackNode below;

    public Stack(int capacity){
        this.capacity = capacity;
    }

    public void join(StackNode above, StackNode below){
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }

    public  boolean push(int value){
        if (isFull()) return false;
        StackNode newNode = new StackNode(value);
        size++;
        if (size == 1) below = newNode;
        join(newNode, top);
        top = newNode;
        return true;
    }

    public int pop(){
        if(size == 0 ||  top == null || below == null)
            throw new EmptyStackException();

        int res = top.value;
        top = top.below;
        size--;
        return res;
    }

    public boolean isFull(){
        return size >= capacity;
    }


}
