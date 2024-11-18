package com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.singleton;

public class Singleton {

    private static Singleton SINGLETON_INSTANCE;

    private Singleton() {
        System.out.println("Singleton constructor invoked!!!");
    }

    public static Singleton newInstance() {
        if (SINGLETON_INSTANCE == null)
            SINGLETON_INSTANCE = new Singleton();
        return SINGLETON_INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello, this is a Singleton!");
    }
}