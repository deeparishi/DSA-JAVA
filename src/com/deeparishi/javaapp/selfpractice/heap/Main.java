package com.deeparishi.javaapp.selfpractice.heap;

public class Main {

    public static void main(String[] args) {

        Heap<Integer> heap = new Heap<>();

        heap.insert(5);
        heap.insert(7);
        heap.insert(9);
        heap.insert(8);
        heap.insert(11);
        heap.insert(12);
        heap.insert(14);
        heap.insert(13);
        heap.insert(10);

        heap.print();

        System.out.println(heap.remove());

        heap.print();

        System.out.println(heap.heapSort());
        heap.print();


    }
}
