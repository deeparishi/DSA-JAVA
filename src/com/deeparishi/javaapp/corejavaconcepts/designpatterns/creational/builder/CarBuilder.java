package com.deeparishi.javaapp.corejavaconcepts.designpatterns.creational.builder;

public class CarBuilder {

    private final Car CAR;

    public CarBuilder() {
        this.CAR = new Car();
    }

    public CarBuilder setCarName(String carName) {
        CAR.setCarName(carName);
        return this;
    }

    public CarBuilder setModel(String model) {
        CAR.setModel(model);
        return this;
    }

    public CarBuilder setWheels(int wheels) {
        CAR.setWheels(wheels);
        return this;
    }

    public CarBuilder setSeat(int seat) {
        CAR.setSeat(seat);
        return this;
    }

    public CarBuilder setEngine(String engine) {
        CAR.setEngine(engine);
        return this;
    }

    public Car build(){
        return this.CAR;
    }
}
