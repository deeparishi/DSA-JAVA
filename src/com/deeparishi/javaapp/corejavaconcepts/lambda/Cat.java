package com.deeparishi.javaapp.corejavaconcepts.lambda;

public class Cat implements Printable{

    String name;

    String color;

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }


    @Override
    public void print() {
        System.out.println(name);
    }
}
