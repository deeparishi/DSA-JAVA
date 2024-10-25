package com.deeparishi.javaapp.leetcode.stack;


import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-node-in-linked-list/description/?envType=problem-list-v2&envId=stack

public class NextGreaterNodeLL {

    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(7);
        node.next.next = new Node(4);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(5);

        int[] a = nextLargerNodes(node);

        for (int b : a)
            System.out.println(b);
    }

    static int[] nextLargerNodes(Node head) {
        List<Integer> list = new ArrayList<>();
        Node temp = head;

        while (temp != null){
            list.add(temp.value);
            temp = temp.next;
        }

        int[] res = new int[list.size()];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < list.size(); i++) {
            while (!st.isEmpty() && list.get(i) > list.get(st.peek()))
                res[st.pop()] = list.get(i);  // Update the result for the popped index

            st.push(i);
        }

        return res;
    }
}
