package com.deeparishi.javaapp.leetcode.recursion;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

//https://leetcode.com/problems/add-two-numbers/?envType=problem-list-v2&envId=recursion

public class AddTwoNode {

    public static void main(String[] args) {

        Node l1 = new Node(9);
        l1.next = new Node(9);
        l1.next.next = new Node(9);
        l1.next.next.next = new Node(9);
        l1.next.next.next.next = new Node(9);
        l1.next.next.next.next.next = new Node(9);
        l1.next.next.next.next.next.next = new Node(9);

        Node l2 = new Node(9);
        l2.next = new Node(9);
        l2.next.next = new Node(9);
        l2.next.next.next = new Node(9);

        Node result = addTwoNumbers(l1, l2);
        printList(result);
    }

    static Node addTwoNumbers(Node l1, Node l2) {
        return helperToAddTwoNumbers(l1, l2, 0);
    }

    static Node helperToAddTwoNumbers(Node l1, Node l2, int carry) {

        if(carry == 0 && l1 == null && l2 == null)
            return null;

        int sum = carry;

        if(l1 != null){
            sum += l1.value;
            l1 = l1.next;
        }

        if(l2 != null){
            sum += l2.value;
            l2 = l2.next;
        }

        Node node = new Node(sum % 10);
        int newCarry = sum/10;

        node.next = helperToAddTwoNumbers(l1, l2, newCarry);
        return node;


    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.value);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}
