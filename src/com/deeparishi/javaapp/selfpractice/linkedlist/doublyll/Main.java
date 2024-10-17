package com.deeparishi.javaapp.selfpractice.linkedlist.doublyll;

import java.util.LinkedList;

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

    }
}
