package com.deeparishi.javaapp.corejavaconcepts.concurrency.completableFuture;

import com.deeparishi.javaapp.corejavaconcepts.concurrency.completableFuture.db.Employee;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingThen {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        singleThreadExecutionWithDefaultThread();
        asyncThreadExecutionWithCustomizedThread();
        handlingException();
        runAfterAsyncForSupply();
        runAfterAsyncForRunType();

    }

    private static void singleThreadExecutionWithDefaultThread()
            throws ExecutionException, InterruptedException {

        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(() -> {
            System.out.println("fetchEmployee : " + Thread.currentThread().getName());
            return Employee.generateEmployees();
        }).thenApply(employees -> {
            System.out.println("Filter By Age : " + Thread.currentThread().getName());
            return employees.stream()
                    .filter(employee -> employee.getAge() > 10)
                    .toList();
        }).thenApply(employees -> {
            System.out.println("Is New Joined : " + Thread.currentThread().getName());
            return employees.stream()
                    .filter(Employee::isNewJoined)
                    .toList();
        }).thenApply(employees -> {
            System.out.println("Collecting name : " + Thread.currentThread().getName());
            return employees.stream()
                    .map(Employee::getName)
                    .toList();
        }).thenAccept(names -> {
            System.out.println("Calling Mail Service : " + Thread.currentThread().getName());
            names.forEach(UsingThen::sendMail);
        });

        future.get();
    }

    private static void asyncThreadExecutionWithCustomizedThread() throws ExecutionException, InterruptedException {

        ExecutorService executors = Executors.newFixedThreadPool(3);


        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("fetchEmployee : " + Thread.currentThread().getName());
            return Employee.generateEmployees();
        }, executors).thenApplyAsync(employees -> {
            System.out.println("Filter By Age : " + Thread.currentThread().getName());
            return employees.stream()
                    .filter(employee -> employee.getAge() > 10)
                    .toList();
        }, executors).thenApplyAsync(employees -> {
            System.out.println("Is New Joined : " + Thread.currentThread().getName());
            return employees.stream()
                    .filter(Employee::isNewJoined)
                    .toList();
        }, executors).thenApplyAsync(employees -> {
            System.out.println("Collecting name : " + Thread.currentThread().getName());
            return employees.stream()
                    .map(Employee::getName)
                    .toList();
        }, executors).thenAcceptAsync(names -> {
            System.out.println("Calling Mail Service : " + Thread.currentThread().getName());
            names.forEach(UsingThen::sendMail);
        }, executors);

        if (executors.isTerminated())
            executors.shutdown();
        future.get();
    }

    private static void handlingException() throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> orderPizza())
                .thenApply(pizza -> eatPizza())
                .thenApply(pizza -> addSauce())
                .exceptionally(e -> {
                    System.out.println(e.getMessage());
                    return null;
                })
                .whenComplete((result, exception) -> {
                    if (exception == null) {
                        System.out.println("Task completed successfully with result: " + result);
                    } else {
                        System.out.println("Task failed with exception: " + exception.getMessage());
                    }
                });

        System.out.println("Doing homework while waiting...");
        System.out.println(future.get());
    }

    private static void runAfterAsyncForSupply() {

        CompletableFuture<String> vegPizza = CompletableFuture.supplyAsync(() -> orderPizza())
                .thenApplyAsync((pizza) -> addSauce())
                .thenApplyAsync(pizz -> eatPizza());

        CompletableFuture<String> chickenPizza = CompletableFuture.supplyAsync(() -> orderPizza())
                .thenApplyAsync((pizza) -> addSauce())
                .thenApplyAsync(pizz -> eatPizza());

        // All statements were executed bcz its not in async
        vegPizza.thenAcceptBoth(chickenPizza, (vegResult, chickenResult) -> {
            System.out.println("Both pizzas are finished!");
            System.out.println("Veg Pizza Status: " + vegResult);
            System.out.println("Chicken Pizza Status: " + chickenResult);
        });

        // All statements were not executed bcz its in async
        vegPizza.thenAcceptBothAsync(chickenPizza, (vegResult, chickenResult) -> {
            System.out.println("Both pizzas are finished!");
            System.out.println("Veg Pizza Status: " + vegResult);
            System.out.println("Chicken Pizza Status: " + chickenResult);
        });

        System.out.println("Doing Homwork.....");
    }

    private static void runAfterAsyncForRunType() {

        CompletableFuture<Void> vegPizza = CompletableFuture.runAsync(() -> {
            orderPizza();
            addSauce();
            eatPizza();
        });

        CompletableFuture<Void> chickenPizza = CompletableFuture.runAsync(() -> {
            orderPizza();
            addSauce();
            eatPizza();
        });

        vegPizza.thenRun(() -> System.out.println("Veg Pizza Finished"));
        vegPizza.thenRunAsync(() -> System.out.println("Veg Pizza Finished"));

        // After both tasks are done, perform a follow-up action
        vegPizza.thenAcceptBoth(chickenPizza, (a, b) -> {
            System.out.println("Both pizzas are finished!");
        });
    }

    private static String addSauce() {
//        int a = 10/ 0; // Intentional error
        return "Adding the sauce";
    }

    private static String eatPizza() {
        return "Eating the pizza";
    }

    private static String orderPizza() {
        return "Pizza Ordered";
    }

    private static void sendMail(String email) {
        System.out.println("Sending mail to :".concat(email));
    }
}

/*
    COMPLETABLE FUTURE is an class which implemets Future & Completion stage
        A future result of a computation that may complete at some point, allowing non-blocking operations.
        It provides a way to handle tasks in the background, chain them, and deal with errors effectively

     Key Items
       Runs tasks in a separate thread without blocking the main thread.
       It execute dependent tasks sequentially/async using methods like thenApply/thenApplyAsync, thenAccept/thenAcceptAync, etc.
       Unlike Future, it doesn't require explicit blocking with get()
       It allows built-in exception handling using exceptionally, handle, or whenComplete
       It can run multiple tasks concurrently and combine their results using methods like thenCombine and allOf

       whenComplete()
         useful for logging the results or errors after a task completes

       thenRunAsync(),
          this allows you to perform further actions once the first task finishes.
          It doesn't require any value from the previous task.

       thenAcceptBoth()
            This runs an action after both CompletableFuture instances (veg and chicken pizza) are complete.

 */