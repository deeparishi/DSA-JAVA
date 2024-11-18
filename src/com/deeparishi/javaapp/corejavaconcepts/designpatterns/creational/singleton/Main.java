package com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.singleton;

public class Main {

    /**
         The Singleton Pattern ensures that a class has only one instance throughout the application,
         and it provides a global point of access to that instance.
     */

    public static void main(String[] args) {

        Singleton singleton = Singleton.newInstance();
        singleton.showMessage();

        Singleton anotherSingleton = Singleton.newInstance();
        anotherSingleton.showMessage();

        System.out.println(singleton.equals(anotherSingleton));
        System.out.println(singleton == anotherSingleton);
    }
}
