package com.deeparishi.javaapp.old.leetcode;

import java.util.concurrent.Semaphore;

public class H2O {
    // Semaphores to control the number of hydrogen and oxygen threads
    private final Semaphore hydrogenSemaphore = new Semaphore(2); // Allows up to 2 hydrogen threads
    private final Semaphore oxygenSemaphore = new Semaphore(1); // Allows up to 1 oxygen thread

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // Acquire hydrogen semaphore
        hydrogenSemaphore.acquire();

        // Release hydrogen (form bond)
        releaseHydrogen.run(); // This would print "H"

        // Release hydrogen semaphore for next set
        hydrogenSemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // Acquire oxygen semaphore
        oxygenSemaphore.acquire();

        // Release oxygen (form bond)
        releaseOxygen.run(); // This would print "O"

        // Release oxygen semaphore for next set
        oxygenSemaphore.release();
    }
}

 class s {
    public static void main(String[] args) {
        H2O h2o = new H2O();

        // Example of creating threads for hydrogen and oxygen
        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");

        // Create threads
        Thread h1 = new Thread(() -> {
            try {
                h2o.hydrogen(releaseHydrogen);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread h2 = new Thread(() -> {
            try {
                h2o.hydrogen(releaseHydrogen);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread o1 = new Thread(() -> {
            try {
                h2o.oxygen(releaseOxygen);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start threads
        h1.start();
        h2.start();
        o1.start();
    }
}


