package com.deeparishi.javaapp.lld.parking.model;

public abstract class ParkingSpot {

    protected String spotName;
    protected int floorNo;
    protected int slot;
    protected boolean isOccupied;
    protected int nearbyDistanceToEntranceInMeter;
    protected int nearbyDistanceToElevatorInMeter;
    protected int nearbyDistanceToEscalatorInMeter;
    protected Vehicle vehicle;

    public ParkingSpot(String spotName, int floorNo, int slot,
                       boolean isOccupied, int nearbyDistanceToEntranceInMeter,
                       int nearbyDistanceToElevatorInMeter,
                       int nearbyDistanceToEscalatorInMeter) {
        this.spotName = spotName;
        this.floorNo = floorNo;
        this.slot = slot;
        this.isOccupied = isOccupied;
        this.nearbyDistanceToEntranceInMeter = nearbyDistanceToEntranceInMeter;
        this.nearbyDistanceToElevatorInMeter = nearbyDistanceToElevatorInMeter;
        this.nearbyDistanceToEscalatorInMeter = nearbyDistanceToEscalatorInMeter;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean free() {
        return !this.isOccupied;
    }

    public boolean occupy(Vehicle v) {
        if (!this.isOccupied) {
            this.vehicle = v;
            this.isOccupied = true;
            return true;
        }
        return false;

    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public void vacate() {
        this.isOccupied = false;
    }

    public int getFloorNo() {
        return this.floorNo;
    }

    public int getSlot() {
        return this.slot;
    }

    public int getNearbyDistanceToEscalatorInMeter() {
        return nearbyDistanceToEscalatorInMeter;
    }

    public int getNearbyDistanceToElevatorInMeter() {
        return nearbyDistanceToElevatorInMeter;
    }

    public int getNearbyDistanceToEntranceInMeter() {
        return nearbyDistanceToEntranceInMeter;
    }
}