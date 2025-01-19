package com.deeparishi.javaapp.leetcode.concurrency;

import java.util.concurrent.Semaphore;

// https://leetcode.com/problems/print-in-order/

public class PrintInOrder {

    public static void main(String[] args) {
        Foo foo = new Foo();

        Thread thread1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread3.start();
        thread2.start();
        thread1.start();
    }
}

class Foo {

    private Semaphore two;
    private Semaphore three;

    public Foo() {
        two = new Semaphore(0);
        three = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
        two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        two.acquire();
        printSecond.run();
        three.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        three.acquire();
        printThird.run();
    }
}
