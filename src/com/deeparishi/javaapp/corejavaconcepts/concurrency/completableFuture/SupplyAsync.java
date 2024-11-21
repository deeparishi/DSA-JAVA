package com.deeparishi.javaapp.corejavaconcepts.concurrency.completableFuture;

import com.deeparishi.javaapp.corejavaconcepts.concurrency.completableFuture.db.Employee;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.deeparishi.javaapp.corejavaconcepts.concurrency.completableFuture.db.Employee.generateEmployees;

public class SupplyAsync {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        supplyAsyncByDefaultExecutor();
        supplyAsyncByCustomExecutor();

    }

    private static void supplyAsyncByCustomExecutor() throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<List<Employee>> supplyAsync = CompletableFuture
                .supplyAsync(
                        () -> {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            List<Employee> employees = generateEmployees();
                            System.out.println("Thread name - " + Thread.currentThread().getName());
                            return employees;
                        }, executor
                );
        System.out.println(supplyAsync.get().size());
        executor.shutdown();
    }

    private static void supplyAsyncByDefaultExecutor() throws InterruptedException, ExecutionException {

        CompletableFuture<List<Employee>> supplyAsync = CompletableFuture
                .supplyAsync(
                        () -> {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            List<Employee> employees = generateEmployees();
                            System.out.println("Thread name - " + Thread.currentThread().getName());
                            System.out.println(employees.size());
                            return employees;
                        }
                );

        System.out.println(supplyAsync.get().size());

    }
}
/*
    supplyAsync()
         Used when you need to run a task asynchronously and return a result from that task.
         Returns a CompletableFuture<T>, where T is the type of the result the task produces.
         Ideal for running tasks that perform some computation or fetch data and return a result.
         Can chain with thenApply/thenApplyAsync, thenAccept, etc.
 */