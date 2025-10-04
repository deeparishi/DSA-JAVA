package com.deeparishi.javaapp.lld.parking.service.impl.spot;

import com.deeparishi.javaapp.lld.parking.model.ParkingSpot;

public class TwoWheelerParkingSpot extends ParkingSpot {


    public TwoWheelerParkingSpot(String spotName, int floorNo, int slot,
                                 boolean isOccupied, int nearbyDistanceToEntranceInMeter,
                                 int nearbyDistanceToElevatorInMeter, int nearbyDistanceToEscalatorInMeter) {
        super(spotName, floorNo, slot, isOccupied, nearbyDistanceToEntranceInMeter,
                nearbyDistanceToElevatorInMeter, nearbyDistanceToEscalatorInMeter);
    }
}
