package com.deeparishi.javaapp.concurrencyproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class ProducerConsumerProblem {
    public static void main(String[] args) {

        ProducerConsumer producerConsumer = new ProducerConsumer(new LinkedList<>(), 5);

        new Thread(() -> IntStream.rangeClosed(1, 150)
                .forEach(i -> {
                    producerConsumer.put(i);
                    sleep(100);
                })).start();

        new Thread(() -> IntStream.rangeClosed(1, 150)
                .forEach(i -> {
                    producerConsumer.poll();
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

class ProducerConsumer {
    private final Queue<Integer> queue;
    private final int capacity;

    public ProducerConsumer(Queue<Integer> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }

    public synchronized void put(int val) {
        while (queue.size() == this.capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Produce: " + val);
        queue.add(val);
        notifyAll();
    }

    public synchronized void poll() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Consumer: " + queue.poll());
        notifyAll();
    }
}
