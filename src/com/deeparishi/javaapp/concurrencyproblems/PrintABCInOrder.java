package com.deeparishi.javaapp.concurrencyproblems;

public class PrintABCInOrder {
    public static void main(String[] args) {
        ABCPrinter abcPrinter = new ABCPrinter();
        new Thread(abcPrinter::a, "A Thread").start();
        new Thread(abcPrinter::b, "B Thread").start();
        new Thread(abcPrinter::c, "C Thread").start();
    }

    static class ABCPrinter {

        private int state = 0;
        private int times = 1;
        private final int MAX = 45;

        public synchronized void a() {
            while (times <= MAX) {
                while (state != 0) {
                    try {
                        wait();
                    } catch (InterruptedException _) {
                    }
                }

                System.out.print("A");
                times++;
                state = 1;
                notifyAll();
            }
        }

        public synchronized void b() {
            while (times <= MAX) {
                while (state != 1) {
                    try {
                        wait();
                    } catch (InterruptedException _) {
                    }
                }
                System.out.print("B");
                times++;
                state = 2;
                notifyAll();
            }
        }

        public synchronized void c() {
            while (times <= MAX) {
                while (state != 2) {
                    try {
                        wait();
                    } catch (InterruptedException _) {
                    }
                }

                System.out.print("C ");
                times++;
                state = 0;
                notifyAll();
            }
        }
    }
}

