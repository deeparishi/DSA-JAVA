package com.deeparishi.javaapp.corejavaconcepts.reflection;

public class DummyClass{

    public String messageOne;

    public String messageTwo;

    private String messageThree;

    private String messageFour;


    // It will execute if the class get loaded, meaning if we load the class using class.forName()
    static {
        System.out.println(" From Static block");
    }

    // It will execute if we create the object for the class, below block is called instance block
    {
        System.out.println(" From Instance BLock");
    }

    // It will execute if we create the constructor for the object
    DummyClass() {
        System.out.println(" From Constructor Block");
    }

    // It will execute if we call this method with the help of className, bcs it's static method
    public static void show() {
        System.out.println(" From static Method");
    }

    private void privateMethodWithArg(String msg, int num) {
        System.out.println("Private method args says " + msg);
    }

    private void privateMethodWithoutArg() {
        System.out.println("Private without method args");
    }

    public void publicMethodWithArg(String msg) {
        System.out.println("Public method args that is " + msg);
    }

    public void publicMethodWithoutArg() {
        System.out.println("Public method args");
    }

}
