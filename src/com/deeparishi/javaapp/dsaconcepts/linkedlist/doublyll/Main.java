package com.deeparishi.javaapp.dsaconcepts.linkedlist.doublyll;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> dd = new DoublyLinkedList<>();

        dd.insert(1);
        dd.insert(2); // 0
        dd.insert(3); // 1
        dd.insert(4);
        dd.insert(5); // 2
        dd.insert(6); // 3
        System.out.println("Original");
        dd.print();
        System.out.println("First");
        dd.delete(1);
        dd.print();
        System.out.println("Second");
        dd.delete(4);
        dd.print();
        System.out.println("Third");
        dd.delete(6);
        dd.print();
        System.out.println("fourth");
        dd.deleteAt(2);
        dd.print();
        System.out.println("final");
        dd.deleteAt(122);
        dd.print();


        CircularDoublyLinkedList<Integer> cc = new CircularDoublyLinkedList<>();

        cc.insertAtBeginning(12);
        cc.insert(13);
        cc.insert(14);
        cc.insert(15);
        cc.insert(16);
        cc.insert(17);
        cc.insert(3, 14);
        cc.insert(8,18);
        cc.insert(0,11);
//        cc.print();

//        System.out.println();
//        System.out.println("Äfter Deletion");
//        cc.deleteAt(0);
//        cc.print();
//
//        System.out.println();
//        System.out.println("Äfter Deletion of Index 7");
//        cc.deleteAt(7);
//        cc.print();
//
//        System.out.println();
//        System.out.println("Äfter Deletion of Index 6");
//        cc.deleteAt(6);
//        cc.print();
//
//        System.out.println();
//        System.out.println("Äfter Deletion of value 15");
//        cc.delete(15);
//        cc.print();
//
//        System.out.println();
//        System.out.println("Äfter Deletion of index 0");
//        cc.deleteAt(0);
//        cc.print();

        CircularDoublyLinkedList<Integer> ccc = new CircularDoublyLinkedList<>();

        ccc.insert(1);
        ccc.insert(1);
        ccc.insert(2);
        ccc.insert(3);
        ccc.insert(3);
        ccc.insert(4);
        ccc.insert(5);
        ccc.insert(5);

        Set<Integer> s = ccc.removeDuplicates();
        for (Integer ss : s){
            System.out.println(ss);
        }
    }
}
