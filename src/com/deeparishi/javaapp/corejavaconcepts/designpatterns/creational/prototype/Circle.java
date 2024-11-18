package com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.prototype;


//Each concrete class implements the clone method to return a copy of itself.

public class Circle implements Prototype{

    private int radius;

    private String color;

    public Circle() {
    }

    public Circle(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    // // Clone method creates a new Circle with the same properties
    @Override
    public Prototype cloneObject() {
        return new Circle(this.radius, this.color);
    }

    @Override
    public String toString() {
        return "Circle [Radius=" + radius + ", Color=" + color + "]";
    }
}