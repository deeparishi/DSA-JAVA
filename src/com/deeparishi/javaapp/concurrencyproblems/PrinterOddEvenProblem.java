package com.deeparishi.javaapp.concurrencyproblems;

public class PrinterOddEvenProblem {
    public static void main(String[] args) {

        Printer printer = new Printer();

        new Thread(printer::printOdd, "odd-1").start();
        new Thread(printer::printEven, "even-2").start();
        new Thread(printer::printEven, "even-3").start();
        new Thread(printer::printOdd, "odd-4").start();
    }

    static class Printer {

        private int num = 1;
        private final int MAX = 100;

        public synchronized void printOdd() {
            while (num <= MAX) {
                while (num % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException _) {}
                }
                System.out.println(STR."\{Thread.currentThread().getName()}: \{num}");
                num++;
                notifyAll();
            }
        }

        public synchronized void printEven() {
            while (num < MAX) {
                while (num % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException _) {}
                }
                System.out.println(STR."\{Thread.currentThread().getName()}: \{num}");
                num++;
                notifyAll();
            }
        }
    }
}


