package com.deeparishi.javaapp.corejavaconcepts.concurrency.executor;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceClass {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorServiceClass service = new ExecutorServiceClass();

            singleThreadExecutor();
            service.fixedThreadPoolMethod();
            schedulerThreadPoolMethod();
            invokeAny();
            invokeAll();
    }

    private static void singleThreadExecutor() {
        // Example for Single Thread Executor

        /*
            once executed the loop from 1-50 then only next thread for 51-100 loop will be executed
            but without any intervention b/w this loops main loop's thread will be executed,
            (i.e) it won't wait to execute that two loop
         */
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            for (int i = 1; i <= 50; i++)
                System.out.print(i + " ");
        });

        executorService.execute(new Thread(() -> {
                    System.out.println();
                    for (int i = 51; i <= 100; i++)
                        System.out.print(i + " ");
                })
        );

        System.out.println("From Main thread..... \n");
        for (int i = 150; i <= 200; i++)
            System.out.print(i + " ");

        executorService.shutdown();
    }

    private void fixedThreadPoolMethod() {
        // Example for Fixed Thread Pool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        fixedThreadPool.execute(new Task(1));
        fixedThreadPool.execute(new Task(2));
        fixedThreadPool.execute(new Task(3));
        fixedThreadPool.execute(new Task(4));
        fixedThreadPool.shutdown();

        /*
         Fixed Thread Pool explanation -
        The thread pool has 2 threads, so it can execute up to 2 tasks simultaneously.
        Tasks are queued if all threads are busy.
        Execution proceeds as follows:
            Thread-1 and Thread-2 pick up Task(1) and Task(2) respectively.
            Once either thread finishes, it picks up the next task from the queue (Task(3) or Task(4)).
         */
    }

    private static void schedulerThreadPoolMethod() throws InterruptedException {

        //the pool size is 2. It means up to 2 tasks can run concurrently.
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);

        /*  for schedule()
            The task is scheduled to execute after a 2-second delay when program started.
            Once executed, the task does not repeat because schedule() is designed for a single execution only.
         */
        scheduledExecutor.schedule(() ->
                System.out.println("Reminder: Task executed after 2 seconds delay"), 2, TimeUnit.SECONDS);

        /*
            Schedules a repeating task:
            Initial Delay: Starts immediately (0 seconds).
            Period: Repeats every 3 seconds.
         */
        scheduledExecutor.scheduleAtFixedRate(() ->
                System.out.println("Periodic Task: Runs every 3 seconds"), 0, 3, TimeUnit.SECONDS);


        /*
             Schedule a task to run repeatedly with a fixed delay between the completion of one execution and the start of the next.
                The task is executed immediately after the executor is started (initial delay = 0).
                Once the task finishes, the scheduler waits for 12 seconds before starting the next execution.
                This cycle repeats until the executor is shut down or the program terminates.
         */
        scheduledExecutor.scheduleWithFixedDelay(() ->
                        System.out.println("Periodic Task: Runs every 12 seconds"), 0,
                12, TimeUnit.SECONDS);

        Thread.sleep(30000);
        scheduledExecutor.shutdown();
        System.out.println("Scheduler shut down.");
    }

    private static void invokeAny() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> {
            Thread.sleep(2000); // Simulate delay
            return "Result from Task 1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1000); // Simulate faster completion
            return "Result from Task 2";
        };

        Callable<String> task3 = () -> {
            Thread.sleep(3000);
            return "Result from Task 3";
        };

        // invokeAny submits all tasks but returns the result of the fastest task
        String result = executorService.invokeAny(List.of(task1, task2, task3));
        System.out.println("First completed task result: " + result);

        executorService.shutdown();
    }

    private static void invokeAll() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> {
            Thread.sleep(2000);
            return "Result from Task 1";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Result from Task 2";
        };

        Callable<String> task3 = () -> {
            Thread.sleep(3000);
            return "Result from Task 3";
        };

        // invokeAll submits all tasks and waits for all of them to complete
        List<Future<String>> results = executorService.invokeAll(List.of(task1, task2, task3));

        for (Future<String> future : results) {
            try {
                System.out.println("Task result: " + future.get());
            } catch (ExecutionException e) {
                System.err.println("Error occurred in task: " + e.getMessage());
            }
        }

        executorService.shutdown();

    }
}




/*

    ExecutorService Interface -
        ExecutorService is an interface (which extends Executor class) that provides methods for managing and controlling threads efficiently.
        It helps you create, schedule, and execute tasks asynchronously
        (without waiting for each task to finish before starting the next)

        Handles thread creation and reuse, so you don’t need to manage threads manually.
        Allows you to submit tasks for execution (Runnable or Callable).
        Provides methods to shut down the thread immediately.
        Allows you to track the progress of a submitted task and retrieve its result

    EXECUTORS -
       Executors is a class that helps to create and manage a group of threads.
       Instead of creating and managing threads manually, Executors handle the thread, making code cleaner and more efficient.
       It simplifies the process of working with threads by offering preconfigured setups like
               -> fixed thread pools
               -> cached thread pools
               -> single-threaded executors

       newFixedThreadPool(int nThreads) -
            Creates a thread pool with a fixed number of threads.
            Useful for processing a large number of tasks with a limit on threads.

       newCachedThreadPool() -
            Creates a thread pool that dynamically adjusts the number of threads based on demand.
            Good for short-lived tasks.

       newSingleThreadExecutor() -
            Creates a single thread executor.
            Ensures tasks are executed one at a time in the order they are submitted.

      newScheduledThreadPool(int corePoolSize) -
            Creates a thread pool that can schedule tasks to run after a delay or repeatedly at fixed intervals.


       What Are Executors?
         Executors are a utility class for creating and managing thread pools to handle concurrent tasks efficiently.

       Why Use Executors?
         They reduce the complexity of thread management, improve performance by reusing threads,
         and make it easier to implement concurrent programming.

      invokeAny() and invokeAll() are methods in the ExecutorService interface that allow you to execute multiple tasks
      concurrently and manage their result

      invokeAny()
        Submits a collection of tasks and returns the result of the first successfully completed task.
        The rest of the tasks are canceled if possible
        Executes all the tasks in parallel.
        As soon as one task completes successfully, it stops waiting for others and returns the result.

      invokeAll()
         Submits a collection of tasks and returns a list of Future objects, each representing the result of one task.
         Executes all tasks in parallel.
         Waits for all tasks to complete before returning the results.
         Does not cancel any tasks; it ensures all are executed.


 */
