package com.deeparishi.javaapp.corejavaconcepts.concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(10);
        semaphore.acquire();
        semaphore.acquire();
        semaphore.acquire();
        semaphore.acquire();
        semaphore.acquire();

        semaphore.release();
        semaphore.release();
        semaphore.release();
        semaphore.release();

        System.out.println("Queue Length       ->  "+  semaphore.getQueueLength());
        System.out.println("Available Permits  ->  "+  semaphore.availablePermits());
        System.out.println("Drain Permits      ->  "+  semaphore.drainPermits());
        System.out.println("Available Permits  ->  "+  semaphore.availablePermits());
        System.out.println("Has Queue Threads  ->  "+  semaphore.hasQueuedThreads());
        System.out.println("to String          ->  "+  semaphore.toString());
        System.out.println("Is Fair            ->  "+  semaphore.isFair());



    }

}
