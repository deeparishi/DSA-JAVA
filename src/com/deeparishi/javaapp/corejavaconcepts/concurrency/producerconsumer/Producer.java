package com.deeparishi.javaapp.corejavaconcepts.concurrency.producerconsumer;

public class Producer implements Runnable {

    Worker worker;

    public Producer(Worker worker) {
        this.worker = worker;
        Thread thread = new Thread(this, "Producer");
        thread.start();
    }

    @Override
    public void run() {
        int v = 0;
        while (true) {
            try {
                worker.put(v++);
                Thread.sleep(2000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
