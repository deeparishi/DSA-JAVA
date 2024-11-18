package com.deeparishi.javaapp.dsaconcepts.heap.binaryheap;

public class MainClass {

    public static void main(String[] args) {

        BinaryHeap binaryHeap = new BinaryHeap(6);
        binaryHeap.insert(5);
        binaryHeap.insert(4);
        binaryHeap.insert(3);
        binaryHeap.insert(2);
        binaryHeap.insert(1);
        binaryHeap.insert(0);

        binaryHeap.levelOrder();


    }
}
