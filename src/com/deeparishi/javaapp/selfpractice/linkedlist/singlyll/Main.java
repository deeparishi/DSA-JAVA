package com.deeparishi.javaapp.selfpractice.linkedlist.singlyll;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList ll = new SinglyLinkedList();

        ll.insert(1); // 0
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.insert(6);
        ll.deleteSinglyLinkedList();

//       ll.reverseOptimal();

//        ll.removeByValue(1);
//        ll.removeByValue(3);
//        ll.removeByValue(5);

        ll.print();




    }
}
