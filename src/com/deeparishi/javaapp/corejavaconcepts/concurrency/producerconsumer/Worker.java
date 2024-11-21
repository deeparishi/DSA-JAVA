package com.deeparishi.javaapp.corejavaconcepts.concurrency.producerconsumer;

public class Worker {

    int value;

    boolean isEmpty = true;

    public synchronized void put(int val) throws InterruptedException {
        while (!isEmpty)
            wait();

        System.out.println("Put : " + val + " & Thread : " + Thread.currentThread().getName());
        isEmpty = false;
        this.value = val;
        notify();
    }

    public synchronized void get() throws InterruptedException {
        while (isEmpty)
            wait();

        System.out.println("Get : " + value + " & Thread : " + Thread.currentThread().getName());
        notify();
        isEmpty = true;

    }

}