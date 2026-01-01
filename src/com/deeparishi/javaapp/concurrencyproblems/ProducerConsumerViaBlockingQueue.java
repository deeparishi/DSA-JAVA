package com.deeparishi.javaapp.concurrencyproblems;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class ProducerConsumerViaBlockingQueue {

    private static final BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {

        new Thread(() -> IntStream.rangeClosed(1, 150)
                .forEach(i -> {
                    try {
                        System.out.println("Producer: " + i);
                        bq.put(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
//                    sleep(100);
                })).start();

        new Thread(() -> IntStream.rangeClosed(1, 150)
                .forEach(i -> {
                    System.out.println("Consumer : " + bq.poll());
                    ;
                    sleep(4000);
                })).start();

    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
