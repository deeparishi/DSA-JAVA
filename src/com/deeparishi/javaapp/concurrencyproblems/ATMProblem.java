package com.deeparishi.javaapp.concurrencyproblems;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ATMProblem {

    public static void main(String[] args) {

        List<ATMMachine> machines = Arrays.asList(
                new ATMMachine(1, 38984567.90),
                new ATMMachine(2, 79877865),
                new ATMMachine(3, 198798768.90)
        );

        ATMCentre centre = new ATMCentre(machines);

        for (int i = 0; i <= 50; i++) {
            int id = i;
            int amount = i * 35000;
            int sleepTime = i * 1000;
            new Thread(() -> {
                try {
                    centre.occupy(id, amount, sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

    static class ATMCentre {

        private final List<ATMMachine> atmMachines;
        private final Semaphore semaphore;

        public ATMCentre(List<ATMMachine> atmMachines) {
            this.atmMachines = atmMachines;
            this.semaphore = new Semaphore(atmMachines.size());
        }

        public void occupy(int customerId, double amount) throws InterruptedException {
            semaphore.acquire();
            ATMMachine atmMachine = null;
            try {
                synchronized (atmMachines) {
                    atmMachine = atmMachines.stream()
                            .filter(ATMMachine::isFree)
                            .findFirst()
                            .orElse(null);

                    if (atmMachine == null) {
                        System.out.println(STR."Customer Id - \{customerId} \{Thread.currentThread().getName()}  ATM machine Queue is full, Please wait");
                        return;
                    }
                    atmMachine.lock();
                }
                atmMachine.withdraw(amount);
                System.out.println("Customer " +
                         STR."\{Thread.currentThread().getName()} \{amount} is withdrawn from ATM \{atmMachine.id}");
                Thread.sleep(3000);
            } catch (Exception ignore) {
            } finally {
                semaphore.release();
                if (atmMachine != null) atmMachine.release();
            }
        }

        public void occupy(int customerId, double amount, int sleepTime) throws InterruptedException {
            semaphore.acquire();
            ATMMachine atmMachine = null;
            try {
                synchronized (atmMachines) {
                    atmMachine = atmMachines.stream()
                            .filter(ATMMachine::isFree)
                            .findFirst()
                            .orElse(null);

                    if (atmMachine == null) {
                        System.out.println(STR."Customer Id - \{customerId} \{Thread.currentThread().getName()}  ATM machine Queue is full, Please wait");
                        return;
                    }
                    atmMachine.lock();
                }
                atmMachine.withdraw(amount);
                System.out.println("Customer " +
                        STR."\{Thread.currentThread().getName()} \{amount} is withdrawn from ATM \{atmMachine.id}");
                Thread.sleep(sleepTime);
            } catch (Exception ignore) {
            } finally {
                semaphore.release();
                if (atmMachine != null) atmMachine.release();
            }
        }

    }

    static class ATMMachine {

        private final int id;
        private double balance;
        private boolean isFree;


        public ATMMachine(int id, double balance) {
            this.id = id;
            this.balance = balance;
            this.isFree = true;
        }

        public void lock() {
            this.isFree = false;
        }

        public void release() {
            this.isFree = true;
        }

        public boolean isFree() {
            return this.isFree;
        }

        public double balance() {
            return this.balance;
        }

        public void withdraw(double amount) {
            if (balance >= amount)
                this.balance -= amount;
            else
                System.out.println("Insufficient balance in ATM " + id);
        }

    }
}