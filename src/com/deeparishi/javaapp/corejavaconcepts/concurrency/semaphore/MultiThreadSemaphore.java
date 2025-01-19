package com.deeparishi.javaapp.corejavaconcepts.concurrency.semaphore;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MultiThreadSemaphore {

    final static Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {


        final MultiThreadSemaphore multiThreadSemaphore = new MultiThreadSemaphore();
        final Semaphore semaphore = new Semaphore(20);
        int numThreads = 100;

        var executorService = Executors.newFixedThreadPool(numThreads + 1);
        try {
            for (int i = 0; i < numThreads; i++) {
                executorService.submit(() -> {
                    multiThreadSemaphore.tryAcquire(semaphore);
                });
            }

            executorService.submit(() -> {
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(semaphore.getQueueLength());
                    if(semaphore.getQueueLength() == 0){
                        System.out.println("Task Completed......");
                        break;
                    }

                }
            });
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    private void tryAcquire(Semaphore semaphore) {

        try {
            semaphore.acquire();
            Thread.sleep(RANDOM.nextInt(10000));
            semaphore.release();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
