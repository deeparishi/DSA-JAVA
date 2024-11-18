package com.deeparishi.javaapp.dsaconcepts.heap.binaryheap;

public class BinaryHeap {

    int[] arr;

    private final String MAX = "MAX";
    private final String MIN = "MIN";

    int sizeOfTree;

    public BinaryHeap(int size) {
        this.arr = new int[size + 1];
        this.sizeOfTree = 0;
    }

    public boolean isEmpty() {
        return sizeOfTree == 0;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return arr[1];
    }

    public int size(){
        return sizeOfTree;
    }

    public int insert(int value) {
        if(isFull()) return -1;

        arr[sizeOfTree + 1] = value;
        sizeOfTree++;
        upHeap(sizeOfTree, MIN);
        return value;
    }

    private void upHeap(int index, String heapType) {

        int parent = index / 2;
        if (index <= 1) return;

        if (heapType.equals(MIN)) {
            if (arr[index] < arr[parent]) {
                swap(index, parent);            }
        } else if (heapType.equals(MAX)) {
            if (arr[index] > arr[parent]) {
                swap(index, parent);
            }
        }

        upHeap(parent, heapType);
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void levelOrder() {
        for (int i = 1; i <= sizeOfTree; i++) { // Start from index 1
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private boolean isFull(){
        return sizeOfTree == arr.length - 1;
    }

    public int pop(){
        if(isEmpty()) return -1;

        int res = arr[1];
        arr[1] = arr[sizeOfTree];
        sizeOfTree--;
        downHeap(1, MIN);

        return res;
    }

    private void downHeap(int index, String heapType){

    }
}
