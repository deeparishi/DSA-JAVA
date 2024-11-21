package com.deeparishi.javaapp.corejavaconcepts.concurrency.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureClass {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        callableFuture();
    }

    private static void callableFuture() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        //Callable interface using lambda
        Future<String> callableLambda = executorService.submit(() -> "Hello world !!");

        // Passing the CallableTask which implements Callback
        Future<String> callableClass = executorService.submit(new CallableTask<>("From callable task"));

        // Passing runnable method as Runnable interface
         executorService.submit(runnable());

        // Passing runnable method as Runnable interface with predefined result, which will be returned while calling get() method
        Future<String> runnableInterface = executorService.submit(runnable(), "Hello from runnable interface");

        // It doesn't wait for other threads to execute
        System.out.println("From main thread.....");
        System.out.println("Is Done - " + runnableInterface.isDone());
        System.out.println("Cancelling the thread- " + runnableInterface.cancel(true)); // Comment this if error thrown
        System.out.println("Current State - " +runnableInterface.state().toString());
        System.out.println("Is Cancelled - " +runnableInterface.isCancelled());
        System.out.println("Current Resukt - " +runnableInterface.resultNow());

        System.out.println(Thread.currentThread().getName() + " " +callableLambda.get());
        System.out.println(Thread.currentThread().getName() + " " +callableClass.get());
        System.out.println(Thread.currentThread().getName() + " " +runnableInterface.get());

        // It'll hold the main thread until the get() method gets completed
        System.out.println("Completed....");

        executorService.shutdown();
    }

    private static Runnable runnable() {
        return () -> System.out.println("Runnable Task invoked!!!!");
    }

}

/*
    Future -
      A Future is an interface and represents the result of each thread also, that provides methods to:
          - get()
             Wait for the task's result:
             Blocks the calling thread if the task isn't finished.

          - isDone()
             Checks if the task has completed (either successfully or with an error).
             Does not block.

           - cancel()       Attempts to cancel the execution of the task.
                            After cancelled when we try to call get() method it'll throw error
           - isCancelled()  Checks if the task was successfully canceled.

        It is typically used when tasks are submitted to an ExecutorService for asynchronous execution.




    Callable -
      It is an interface used to define task that can be executed by thread and return result
      T is a generic type that represents the type of result the call() method will return.
      The call() method is the main task logic.
      Runnable doesn't return a result, but Callable does.
      The submit() method of ExecutorService accepts both Runnable and Callable tasks.
      future.get() blocks the main thread until the task completes
      Runnable is designed for tasks that perform operations but do not return a result.

 */
