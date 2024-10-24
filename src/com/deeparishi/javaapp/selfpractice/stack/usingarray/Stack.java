package com.deeparishi.javaapp.selfpractice.stack.usingarray;

public class Stack {

    private int[] arr;

    private int topOfStack;

    private final int DEFAULT_SIZE = 10;


    public Stack(){
        this.arr = new int[DEFAULT_SIZE];
        this.topOfStack = -1;
    }

    public Stack(int size){
        this.arr = new int[size];
        this.topOfStack = -1;
    }

    public int push(int val){

        if (isFull()) return -1;

        arr[++topOfStack] = val;
        return val;
    }

    public int pop(){

        if (isEmpty()) return -1;

        int val = arr[topOfStack];
        arr[topOfStack] = 0;
        topOfStack--;
        return val;
    }



    public int peek(){
        if (isEmpty()) return -1;
        return arr[topOfStack];
    }

    public void delete(){
        this.arr = new int[arr.length];
        topOfStack = -1;
    }

    public void print(){

        for (int i : arr)
            System.out.print(STR."\{i}  ");
        System.out.println();
    }


    public boolean isEmpty(){
        return topOfStack == -1;
    }

    public boolean isFull(){
        return topOfStack == arr.length -1;
    }
}
