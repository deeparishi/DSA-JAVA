package com.deeparishi.javaapp.corejavaconcepts.concurrency.producerconsumer;

public class Consumer implements Runnable{

    Worker worker;

    public Consumer(Worker worker){
        this.worker = worker;
        Thread thread = new Thread(this, "Consumer");
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                worker.get();
                Thread.sleep(2000);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
