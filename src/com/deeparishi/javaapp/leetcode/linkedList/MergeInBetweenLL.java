package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

class MergeInBetweenLL {

    public static void main(String[] args) {

        int[] arr1 = {0, 1, 2, 3, 4, 5, 6};
        int[] arr2 = {25, 26, 27, 28, 29};
        Node list1 = createList(arr1);
        Node list2 = createList(arr2);
        Node finallyAns = mergeInBetweens(list1,3,4, list2);

        System.out.print("Original list1: ");

        System.out.print("List2: ");
    }
    static Node mergeInBetween(Node list1, int a,
                                   int b, Node list2) {

        Node tempA = list1;
        Node tail = null;
        Node n = null;

        int index = 0;

        while (tempA != null){

            if(index == a-1){
                tempA = tempA.next;
                n = tempA;
                n.next = list2;
            }
            if(index >= a && index <=b){
                tail = tempA.next;
            }
            tempA = tempA.next;
        }

        Node tempN = n;
        while (tempN.next != null){
            tempN = tempN.next;
        }

        tempN.next = tail;

        return n;
    }


    static Node mergeInBetweens(Node list1, int a, int b, Node list2) {
        Node prevA = list1;
        Node afterB = list1;

        // Find node just before index 'a'
        for (int i = 0; i < a - 1; i++) {
            prevA = prevA.next;
        }

        // Find node just after index 'b'
        for (int i = 0; i < b + 1; i++) {
            afterB = afterB.next;
        }

        // Link the previous part of list1 to list2
        prevA.next = list2;

        // Find the last node of list2
        Node lastOfList2 = list2;
        while (lastOfList2.next != null) {
            lastOfList2 = lastOfList2.next;
        }

        // Link the last node of list2 to the node after 'b'
        lastOfList2.next = afterB;

        return list1;
    }

    static Node createList(int[] arr) {
        Node dummy = new Node(0);
        Node current = dummy;
        for (int val : arr) {
            current.next = new Node(val);
            current = current.next;
        }
        return dummy.next;
    }

}
