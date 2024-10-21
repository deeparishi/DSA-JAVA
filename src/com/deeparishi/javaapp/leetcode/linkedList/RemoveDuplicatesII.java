package com.deeparishi.javaapp.leetcode.linkedList;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=problem-list-v2&envId=linked-list

import com.deeparishi.javaapp.leetcode.linkedList.utl.LinkedList;
import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;


public class RemoveDuplicatesII {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(3);
        ll.insert(4);
        ll.insert(4);
        ll.insert(5);


        Node temp = deleteDuplicates(ll.head);

        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    static Node deleteDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node dummy = new Node();
        dummy.next = head;

        Node prev = dummy;
        Node current = head;

        while (current != null && current.next != null){
            if(current.value == current.next.value){
                while (current != null && current.next.value == current.value){
                    current = current.next;
                }
                prev.next = current.next;
            }else {
                prev = prev.next;
            }

            current = current.next;
        }

        return dummy.next;
    }

}
