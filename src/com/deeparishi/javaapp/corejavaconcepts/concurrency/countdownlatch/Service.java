package com.deeparishi.javaapp.corejavaconcepts.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Service implements Runnable {

    CountDownLatch countDownLatch;

    private int waitTime;

    public Service(CountDownLatch countDownLatch, int waitTime){
        this.countDownLatch = countDownLatch;
        this.waitTime = waitTime;
    }


    @Override
    public void run() {
        System.out.println("Service Started " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(waitTime);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Service Completed " + Thread.currentThread().getName());
            countDownLatch.countDown();
        }
    }
}
