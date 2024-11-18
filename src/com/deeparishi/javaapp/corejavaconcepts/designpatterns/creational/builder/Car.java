package com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.builder;

public class Car {

    private String carName;

    private String model;

    private int wheels;

    private int seat;

    private String engine;

    public void setModel(String model) {
        this.model = model;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", model='" + model + '\'' +
                ", wheels=" + wheels +
                ", seat=" + seat +
                ", engine='" + engine + '\'' +
                '}';
    }
}
