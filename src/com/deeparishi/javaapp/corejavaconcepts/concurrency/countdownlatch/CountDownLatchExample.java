package com.deeparishi.javaapp.corejavaconcepts.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        System.out.println("Main thread Started");

        new Thread(new Service(countDownLatch, 2000)).start();
        new Thread(new Service(countDownLatch, 2000)).start();
        new Thread(new Service(countDownLatch, 2000)).start();

        countDownLatch.await();
        System.out.println("Main thread Completed");
    }
}
/*
    CountdownLatch is a class in the java.util.concurrent package.
    It's a synchronization tool that allows one or more threads to wait until a set of operations being performed by
    other threads completes.

     It uses a countDown() method to down from a specified number to zero.
      Once the counter reaches zero, all the waiting threads ((i.e) main/parent thread) are released

      - Count Initialization
            new CountDownLatch(3) : You initialize the CountdownLatch with a count (number of tasks to wait for).
      - Counting Down
             countDown() : Other threads call countDown() to decrement the counter.
      - Waiting
              await(): Threads calling await() will block until the counter becomes zero.
                       If this not specified it won't block any thread, so all the tasks were executed parallel
              await(long timeout, TimeUnit unit): Waits for the count to reach zero or until the timeout occurs.

       Important point
           The main thread blocks only until the latch count reaches 0.
           Once the latch count is 0, the main thread proceeds, even if there are still tasks being executed by other threads.
           The latch is a one-time tool; it can’t be reused after it reaches 0
 */