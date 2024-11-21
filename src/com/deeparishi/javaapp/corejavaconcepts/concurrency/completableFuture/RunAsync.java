package com.deeparishi.javaapp.corejavaconcepts.concurrency.completableFuture;

import com.deeparishi.javaapp.corejavaconcepts.concurrency.completableFuture.db.Employee;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunAsync {



    public static void main(String[] args) throws ExecutionException, InterruptedException {


        System.out.println("Main thread started.....");
        runAsyncByDefaultExecutor();
        runAsyncByCustomExecutor();
        System.out.println("Main thread Completed.....");

    }

    private static void runAsyncByCustomExecutor() {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<Void> runAsync = CompletableFuture
                .runAsync(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            List<Employee> employees = Employee.generateEmployees();
                            System.out.println("Thread name - " + Thread.currentThread().getName());
                            System.out.println(employees.size());
                        }
                    }, executor
                );

        executor.shutdown();
    }

    private static void runAsyncByDefaultExecutor() throws InterruptedException, ExecutionException {

        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread name - " + Thread.currentThread().getName());
                List<Employee> employees = Employee.generateEmployees();
                System.out.println(employees.size());
            }
        });

        runAsync.get();
    }

}

/*
    RunAsync()
         Used when you need to run a task asynchronously that doesn't return a result.
         Returns a CompletableFuture<Void>, indicating that no result is produced by the task.
         deal for running a task that performs a side effect (logging, updating a database) without needing to return a value.
         The task runs asynchronously using a default(ForkJoinPool) or custom executor(ExecutorService).
         Can chain with thenRun, thenAccept, etc.

 */
