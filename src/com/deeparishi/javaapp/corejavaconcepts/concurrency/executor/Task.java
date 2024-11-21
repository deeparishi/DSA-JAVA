package com.deeparishi.javaapp.corejavaconcepts.concurrency.executor;

public class Task implements Runnable {

    private final int times;

    public Task(int times) {
        this.times = times;
    }

    @Override
    public void run() {

        System.out.println("Task " + times + " Initiated");

        for (int i = times * 100; i <= times * 100 + 10; i++)
            System.out.print(i + " ");

        System.out.println();
        System.out.println("Task " + times + " Completed");
    }
}