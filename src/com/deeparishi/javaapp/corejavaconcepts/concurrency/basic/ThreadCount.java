package com.deeparishi.javaapp.corejavaconcepts.concurrency.basic;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class ThreadCount {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        int threadCount = threadMXBean.getThreadCount();
        System.out.println("Number of threads in the system: " + threadCount);
        System.out.println("Number of threads " + Thread.activeCount());
    }
}
