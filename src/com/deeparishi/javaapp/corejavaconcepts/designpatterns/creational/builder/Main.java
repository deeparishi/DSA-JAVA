package com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.builder;

/**
      The Builder design pattern is used when you need to construct a complex object step by step
      If an object has many optional parts or complex configurations, the Builder pattern simplifies the
      construction process by handling the details step-by-step and keeping the code clean
 */

public class Main {

    public static void main(String[] args) {

        // Old style to create the object and build with getter & setter's
        Car car = new Car();
        car.setCarName("TATA");
        car.setModel("Nexon");
        car.setEngine("V4");
        car.setSeat(4);
        car.setWheels(4);
        System.out.println(car);

        // Now built the car with the help of builder pattern
        Car car1 = new CarBuilder()
                .setCarName("Skoda")
                .setModel("Rapid")
                .setEngine("V5")
                .setSeat(5)
                .setWheels(4)
                .build();

        System.out.println(car1);

        Car car2 = new CarBuilder()
                .setCarName("Hyundai")
                .setModel("Creta")
                .setEngine("V6")
                .setSeat(5)
                .setWheels(4)
                .build();

        System.out.println(car2);

    }
}