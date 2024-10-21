package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.LinkedList;
import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

import java.util.Stack;

class ReverseBetween {

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insert(1);
        ll1.insert(2);
        ll1.insert(3);
        ll1.insert(4);
        ll1.insert(5);


        Node temp = reverseBetween(ll1.head, 2, 4);
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    static Node reverseBetween(Node head, int left, int right) {

        Node curr = head;
        int index = 1;
        Stack<Integer> st = new Stack<>();

        while (curr != null) {
            if (index >= left && index <= right) {
                st.push(curr.value);
            }
            index++;
            curr = curr.next;
        }

        curr = head;
        index = 1;

        while (curr != null) {
            if (index >= left && index <= right) {
                curr.value = st.pop();
            }
            curr = curr.next;
            index++;
        }

        return head;
    }
}

