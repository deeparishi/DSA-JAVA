package com.deeparishi.javaapp.corejavaconcepts.concurrency.basic;

public class RunnableInterface implements Runnable{

    @Override
    public void run() {
        a();
        b();
    }

    private void a(){
        for (int i = 50; i < 10000; i++) {
            System.out.print(i + " ");
        }
    }

    private void b(){
        for (int i = 11; i < 20; i++) {
            System.out.print(i + " ");
        }
    }
}
