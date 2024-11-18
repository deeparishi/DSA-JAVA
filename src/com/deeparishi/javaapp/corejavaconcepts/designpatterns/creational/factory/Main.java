package com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.factory;

/**
 * The Factory Method design pattern is a way to create objects without directly specifying their exact class.
 * Instead, it provides a common interface for object creation, and the responsibility for deciding the
 * specific type of object to create is left to subclasses.
 */

public class Main {
    public static void main(String[] args) {

        // Drawing the shape directly from implemented class
        Shape squareOne = new Square();
        squareOne.draw();
        System.out.println();

        // Drawing the shape directly from implemented class
        Shape rectangleOne = new Rectangle();
        rectangleOne.draw();
        System.out.println();

        /**  Drawing the shape with the help of factory,
         now shape factory provide us the square factory,
         with the help of square factory we create the square shape
         */
        ShapeFactory squareFactory = new SquareFactory();
        squareFactory.print();
        Shape squareTwo = squareFactory.createShape();
        squareTwo.draw();
        System.out.println();

        /**  Drawing the shape with the help of factory,
         now shape factory provide us the Rectangle factory,
         with the help of Rectangle factory we create the rectangle shape
         */
        ShapeFactory rectangleFactory = new RectangleFactory();
        rectangleFactory.print();
        Shape rectangleTwo = rectangleFactory.createShape();
        rectangleTwo.draw();
        System.out.println();


    }
}

/**
 * This is the common interface that all shape objects (like Circle, Rectangle) will implement.
 * It defines the draw() method.
 */

interface Shape {

    private void create() {
        System.out.println("Creating the Shape!!!");
    }

    void draw();
}

/**
 * Concrete class such as Square & Rectangle
 * These are the concrete implementations of the Shape interface.
 * Each one defines how to draw that particular shape.
 */


class Square implements Shape{

    public void draw() {
        System.out.println("Drawing the square!!!");
    }
}

class Rectangle implements Shape{

    public void draw() {
        System.out.println("Drawing the Rectangle!!!");
    }
}

/**
 *    This is the abstract class with the factory method createShape(),
 *    which will be implemented by the subclasses.
 */

abstract class ShapeFactory {
    public void print() {
        System.out.println("Shape Factory Called!!!");
    }

    abstract Shape createShape();
}

/**
 * These classes override the createShape() method to create specific shapes (Square or Rectangle).
 */

class SquareFactory extends ShapeFactory {

    @Override
    Shape createShape() {
        return new Square();
    }
}

class RectangleFactory extends ShapeFactory {

    @Override
    Shape createShape() {
        return new Rectangle();
    }
}