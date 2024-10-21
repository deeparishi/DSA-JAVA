package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.LinkedList;
import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

// https://leetcode.com/problems/swap-nodes-in-pairs/description/?envType=problem-list-v2&envId=linked-list

public class SwapNodeInPairs {

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
//        ll.insert(4);


        Node temp = swapPairs(ll.head);

        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    static Node swapPairs(Node head) {

        if (head == null || head.next == null) {
            return head;
        }


        Node slow = head;
        Node fast = head.next;

        while (fast != null){
            int a = slow.value;
            int b = fast.value;
            slow.value = b;
            fast.value = a;

            if(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next.next;
            }
            else
                fast = null;

        }

        return head;

    }


}
