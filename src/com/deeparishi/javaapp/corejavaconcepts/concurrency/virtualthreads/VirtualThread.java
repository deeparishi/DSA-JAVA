package com.deeparishi.javaapp.corejavaconcepts.concurrency.virtualthreads;

import java.util.List;
import java.util.stream.IntStream;

public class VirtualThread {

    public static void main(String[] args) throws InterruptedException {

        basics();
        proofThatVirtualThreadIsNonBlocking();
        int totalThread = 100000;
        timeTakenOnVirtualThread(totalThread);
        timeTakenOnParallelThread(totalThread);
    }

    private static void basics() throws InterruptedException {

        Thread.ofPlatform()
                .start(() -> System.out.println("Platform Thread -> " + Thread.currentThread()));

        Thread.ofVirtual()
                .start(() -> System.out.println("Virtual Thread -> " + Thread.currentThread()))
                .join();

    }

    private static void proofThatVirtualThreadIsNonBlocking() throws InterruptedException {

        List<Thread> threads = IntStream.range(0, 100)
                .mapToObj(thCount ->
                        Thread.ofVirtual().unstarted(() -> {
                            if (thCount == 0)
                                System.out.println(Thread.currentThread());
                            try {
                                Thread.sleep(10000);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            if (thCount == 0)
                                System.out.println(Thread.currentThread());
                        })).toList();

        threads.forEach(Thread::start);

        for (Thread thread : threads)
            thread.join();

    }

    private static void timeTakenOnVirtualThread(int totalThread) throws InterruptedException {

        long start = System.currentTimeMillis();

        List<Thread> threads = IntStream.range(0, totalThread)
                .mapToObj(_ -> Thread.ofVirtual().unstarted(() -> {
                }))
                .toList();

        threads.forEach(Thread::start);

        for (Thread thread : threads)
            thread.join();

        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("total virtual thread count : " + totalThread + " which Runs in " + diff + " MS");

    }

    private static void timeTakenOnParallelThread(int totalThread) throws InterruptedException {

        long start = System.currentTimeMillis();

        List<Thread> threads = IntStream.range(0, totalThread)
                .mapToObj(_ -> Thread.ofPlatform().unstarted(() -> {
                }))
                .toList();

        threads.forEach(Thread::start);

        for (Thread thread : threads)
            thread.join();

        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("total platform thread count : " + totalThread + " which Runs in " + diff + " MS");

    }

}