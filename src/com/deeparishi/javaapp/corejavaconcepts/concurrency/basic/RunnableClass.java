package com.deeparishi.javaapp.corejavaconcepts.concurrency.basic;

public class RunnableClass extends Thread{

    @Override
    public void run(){
        System.out.println("Running thread extended from thread class....");
    }

}
