package com.deeparishi.javaapp.lld.parking.model;

public class Vehicle {

    private String vehicleNumber;
    private String model;
    private String color;
    private VehicleType vehicleType;


    public Vehicle(String vehicleNumber, String model, String color, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public enum VehicleType {
        TWO_WHEELER(9),
        FOUR_WHEELER(8),
        HEAVY_VEHICLE(7);

        private final int code;

        VehicleType(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
