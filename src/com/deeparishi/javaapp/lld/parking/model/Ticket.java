package com.deeparishi.javaapp.lld.parking.model;

import java.time.LocalDateTime;
import java.util.Random;

public class Ticket {

    private int id;
    private final int floor;
    private int price;
    private final LocalDateTime enteredAt;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private LocalDateTime exitedAt;


    public Ticket(int floor, LocalDateTime enteredAt, Vehicle vehicle, ParkingSpot parkingSpot) {
        Random random = new Random();
        this.id = random.nextInt(10000);
        this.floor = floor;
        this.enteredAt = enteredAt;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public Ticket(int floor, int price, LocalDateTime enteredAt,
                  Vehicle vehicle, ParkingSpot parkingSpot) {
        this.floor = floor;
        this.price = price;
        this.enteredAt = enteredAt;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public int getFloor() {
        return floor;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getEnteredAt() {
        return enteredAt;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getExitedAt() {
        return exitedAt;
    }

    public void setExitedAt() {
        this.exitedAt = LocalDateTime.now();
    }

}

