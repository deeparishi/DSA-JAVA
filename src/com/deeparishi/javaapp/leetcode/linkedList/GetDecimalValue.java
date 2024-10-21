package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.LinkedList;
import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/?envType=problem-list-v2&envId=linked-list

public class GetDecimalValue {

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insert(1);
        ll1.insert(0);
        ll1.insert(1);
        System.out.println(getDecimalValue(ll1.head));
    }

    static int getDecimalValue(Node head) {
        String s = "";
        Node temp = head;

        while(temp != null){
            s = s.concat(String.valueOf(temp.value));
            temp = temp.next;
        }

        return Integer.parseInt(s, 2);
    }
}
