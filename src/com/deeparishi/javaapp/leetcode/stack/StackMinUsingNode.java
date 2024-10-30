package com.deeparishi.javaapp.leetcode.stack;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

//https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5132866#questions

public class StackMinUsingNode {

    Node input;
    Node tailIp;
    Node output;
    Node tailOp;

    public StackMinUsingNode() {
        input = null;
        output = null;
    }

    public int min() {
        return output.value;
    }

    public void push(int value) {

        Node node = new Node();
        node.value = value;

        if(input == null){
            input = node;
            tailIp = node;
        }else{
            tailIp.next = node;
        }

        if(output == null || value <= output.value){
            output = node;
            tailOp = node;
        }
    }

    public int pop() {
        int poppedValue = input.value;
        input = input.next;

        if (poppedValue == output.value) {
            output = output.next;
        }
        return poppedValue;
    }
}
