package com.deeparishi.javaapp.selfpractice.linkedlist.doublyll;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> dd = new DoublyLinkedList<>();

        dd.insert(1);
        dd.insert(2);
        dd.insert(3);
        dd.insert(4);
        dd.insert(5);
        dd.insert(6);

        dd.insertAt(31, 3);

        dd.print();



    }
}
