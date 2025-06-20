package com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.factory;

public class FactoryPattern {

    public static void main(String[] args) {

        Notification emailNotification = NotificationFactory.createNotification("Email").orElseThrow();
        emailNotification.notifyUser();


        Notification smsNotification = NotificationFactory.createNotification("sms").orElseThrow();
        smsNotification.notifyUser();


        Notification pushNotification = NotificationFactory.createNotification("push").orElseThrow();
        pushNotification.notifyUser();
    }
}

/*

    What is the Factory Pattern?
    A Factory Pattern is used to create objects without exposing the object creation logic to the client.
    Instead of using the new keyword, we use a special method (a factory method) to create objects dynamically.


                    Summary of Factory Pattern
    🔹 What? A pattern to create objects without exposing object creation logic.
    🔹 Why? It improves maintainability, reduces coupling, and centralizes object creation.
    🔹 When? When you have multiple object types and need a flexible way to instantiate them.
    🔹 Where? Used in frameworks like Spring, JDBC, Logging systems, and UI components.
    🔹 How? Use a factory method to return an instance based on input conditions.


            Key Benefits of Using Factory Pattern in This Example
    ✔ The NotificationFactory class controls object creation, so the main code (main method) does not directly use new.
    ✔ If a new notification type (e.g., WhatsApp Notification) is needed, we only modify the factory, not client code.
    ✔ Client code remains clean and loosely coupled.

 */