package com.deeparishi.javaapp.corejavaconcepts.concurrency.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("All friends are at the meeting point! Moving to the next checkpoint."));

        for (int i = 1; i <= 5; i++) {
            Friend friend = new Friend(barrier, "Friend ".concat(String.valueOf(i)));
            friend.start();
        }

        // Reusing the same barrier here for next loop
        for (int i = 11; i <= 15; i++) {
            Friend friend = new Friend(barrier, "Friend ".concat(String.valueOf(i)));
            friend.start();
        }

        System.out.println("Main thread completed");
    }
}

/*
    Cyclic Barrier
         A CyclicBarrier is a synchronization aid in the java.util.concurrent package.
         It allows a group of threads to wait for each other at a common barrier (or meeting point) before proceeding.
         Unlike CountDownLatch, the CyclicBarrier is reusable, meaning it can be reset and
           used again after the threads complete their current cycle.

     Methods
         await(): Blocks the thread until all threads have reached the barrier.
         getParties(): Returns the total number of threads the barrier is waiting for.
         isBroken(): Checks if the barrier is broken due to thread interruption or timeout.
         reset(): Resets the barrier to its initial state.

     UseCase
       Parallel Computation: Splitting a task into subtasks where all threads must synchronize at intermediate stages.

       the main thread will not block in this execution unless the main thread itself calls the await() method on the CyclicBarrier.
 */