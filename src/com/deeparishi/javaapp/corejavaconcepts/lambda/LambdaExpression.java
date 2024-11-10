package com.deeparishi.javaapp.corejavaconcepts.lambda;

public class LambdaExpression {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Pinky", "Pink");
        Cat cat2 = new Cat("Pinky", "Pink");
        printThing(cat2);
        printThing(() -> System.out.println(cat1.name));

    }

    static void printThing(Printable printable){
        printable.print();
    }
}

/**
 * Hereby
 */
