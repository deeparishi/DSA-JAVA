package com.deeparishi.javaapp.selfpractice.linkedlist.singlyll;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();

        ll.insert(1); // 0
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.insert(6);

        ll.reverseOptimal();

        ll.removeByValue(1);
        ll.removeByValue(3);
        ll.removeByValue(5);

//        ll.print();


        CircularSinglyLinkedList<Integer> cc = new CircularSinglyLinkedList<>();

        cc.insert(1);
        cc.insert(2);
        cc.insert(3);
        cc.insert(4);
        cc.insert(5);
        cc.insert(6);
        cc.insert(7);
        cc.insert(8);
        cc.insert(9);
        cc.insert(10);

        cc.delete(1);
        cc.print();
        System.out.println();
        cc.deleteAt(8);
        cc.print();
        System.out.println();
        cc.delete(9);
        cc.print();
        System.out.println();
        cc.deleteAt(3);
        cc.print();


    }
}
