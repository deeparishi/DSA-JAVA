package com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.prototype;

public class Main {

    public static void main(String[] args) {

        Circle originalCircle = new Circle();
        originalCircle.setColor("Yellow");
        originalCircle.setRadius(12);

        Rectangle originalRectangle = new Rectangle(20, 30);

        Circle clonedCircle = (Circle) originalCircle.cloneObject();
        Rectangle clonedRectangle = (Rectangle) originalRectangle.cloneObject();

        System.out.println("Original Circle: " + originalCircle);
        System.out.println("Cloned Circle: " + clonedCircle);

        System.out.println("Original Rectangle: " + originalRectangle);
        System.out.println("Cloned Rectangle: " + clonedRectangle);

    }
}


/**
 *
 * What is Prototype?
 * The Prototype design pattern allows you to create new objects by copying an existing object, called the "prototype."
 * This is useful when creating a new object is expensive or complex, and you want to make a copy of an already
 * existing object instead of creating it from scratch.
 *
 * Why?
 * To avoid the overhead of creating objects from scratch.
 * To create multiple similar objects efficiently by copying an existing one.
 *
 *
 */