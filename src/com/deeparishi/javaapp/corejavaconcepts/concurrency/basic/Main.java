package com.deeparishi.javaapp.corejavaconcepts.concurrency.basic;

public class Main{

    public static void main(String[] args) throws InterruptedException {

        Runnable runnableInterface = new RunnableInterface();
        Thread thread1 = new Thread(runnableInterface);
        thread1.setName("thread1");// To set the thread name
        thread1.setPriority(2); // TO set priority ranges from 1 to 10

        thread1.setDaemon(true); // To invoke Daemon thread
        thread1.start(); // TO start the thread
        System.out.println(thread1.getName()); // To print the thread name
        System.out.println(thread1.getPriority());// To get priority of this thread
        System.out.println("Parent name " + thread1.getThreadGroup().getParent().getName()); // prints the name of the initiator

        thread1.interrupt();
        Thread.sleep(12000); // To sleep for 12 secs
        Thread thread3 = new Thread(new RunnableClass());
        thread3.start();

        System.out.println();
         new Thread(() -> {
                for (int i = 30; i <= 40; i++)  System.out.print(i + " ");
            }
        ).start();

        new Thread( () -> System.out.println("Hi")).start();
        System.out.println("Main thread......");
    }
}

/*
    Daemon Thread:
        -> A daemon thread is a helper thread in Java that runs in the background.
           Its job is to support other threads or the program, like a quiet worker in the background.
           It doesn't keep the program running—if all the main (non-daemon) threads finish, the daemon thread
           will automatically stop, even if it's still working.
        -> Daemon threads terminate when all non-daemon threads in the application finish execution.
        -> Set a thread as a daemon before calling start()

    Thread Priorities
        The default priority that is assigned to a thread = 5
        The minimum priority that a thread can have = 1
        The maximum priority that a thread can have. = 10

 */
