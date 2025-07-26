package com.deeparishi.javaapp.corejavaconcepts.concurrency.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Questions {

    public static void main(String[] args) {
        Questions questions = new Questions();
//        questions.stockMarketQue();
        questions.ecommerceQue();
    }

    /**
     * A financial application retrieves stock prices from three different APIs and needs to compute the average stock price.
     * If any API fails, the system should return a default value for that source.
     * How would you implement this using CompletableFuture?
     */
    public void stockMarketQue() {

        Utils cl = new Utils();

        CompletableFuture<Double> grow = CompletableFuture.supplyAsync(cl::grow)
                .exceptionally((e) -> {
                    System.out.println(e.getMessage());
                    return 0.00;
                });
        ;
        CompletableFuture<Double> tata = CompletableFuture.supplyAsync(cl::tata)
                .exceptionally((e) -> {
                    System.out.println(e.getMessage());
                    return 0.00;
                });

        CompletableFuture<Double> stocks = CompletableFuture.supplyAsync(cl::stocks)
                .exceptionally((e) -> {
                    System.out.println(e.getMessage());
                    return 0.00;
                });


        CompletableFuture<Double> price = grow
                .thenCombine(tata, Double::sum)
                .thenCombine(stocks, Double::sum);

        System.out.println(price.join()/3);
    }

    /**
     * In an e-commerce system, when a user places an order, multiple tasks must run concurrently:
     * Validate the order.
     * Process the payment.
     * Update the inventory.
     * Send a confirmation email.
     * These tasks should execute asynchronously, and the system should proceed only when all are completed.
     * How would you implement?
     */
    public void ecommerceQue() {

        CompletableFuture<Void> orderValidate = CompletableFuture.supplyAsync(() -> {
            IntStream.range(0, 100)
                    .forEach(i -> System.out.println(i + " Order is validating!"));
            return null;
        });

        CompletableFuture<Void> payment = CompletableFuture.supplyAsync(() -> {
            IntStream.range(0, 100)
                    .forEach(i -> System.out.println(i + " Order Id is initiated for payment!"));
            return null;
        });

        CompletableFuture<Void> inventory = CompletableFuture.supplyAsync(() -> {
            IntStream.range(0, 100)
                    .forEach(i -> System.out.println(i + " Inventory getting updated!"));
            return null;
        });

        CompletableFuture<Void> mail = CompletableFuture.supplyAsync(() -> {
            IntStream.range(0, 100)
                    .forEach(i -> System.out.println(i + " Sending the mail"));
            return null;
        });

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(orderValidate, payment, inventory, mail);
        completableFuture.join();
        System.out.println("Order successfully processed!");

    }

}

class Utils {

    public double grow() {
        return 12.34;
    }

    public double tata() {
        return 123.56;
    }

    public double stocks() {
        throw new RuntimeException("Not a app");
    }

}