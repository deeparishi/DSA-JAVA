package com.deeparishi.javaapp.selfpractice.queue.usingLL;

public class Main {


    public static void main(String[] args) {

        Queue queue = new Queue();
        System.out.println(queue.dequeue());
        for (int i = 1; i <= 10; i++) {
            queue.enqueue(i);
        }

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());



    }
}
