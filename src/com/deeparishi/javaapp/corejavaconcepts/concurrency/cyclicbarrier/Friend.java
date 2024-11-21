package com.deeparishi.javaapp.corejavaconcepts.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Friend extends Thread{

    CyclicBarrier barrier;

    String friendName;

    public Friend(CyclicBarrier barrier, String friendName){
        this.barrier = barrier;
        this.friendName = friendName;
    }

    @Override
    public void run() {
        System.out.println(friendName + " is getting ready!!!");

        try {
            getReadyAndBeAtMeetingPoint();
            System.out.println(friendName + " is ready waiting for " +
                    (barrier.getParties() - barrier.getNumberWaiting() - 1) +
                    " Friends at meeting point");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    private void getReadyAndBeAtMeetingPoint() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current()
                .nextLong(5000, 15000));
    }

}
