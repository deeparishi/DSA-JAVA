package com.deeparishi.javaapp.lld.parking.model;

import com.deeparishi.javaapp.lld.parking.service.iservice.ParkingStrategyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingSpotManager {

    private final List<ParkingSpot> parking;

    public List<ParkingSpot> getParking() {
        return parking;
    }

    public ParkingSpotManager() {
        this.parking = new ArrayList<>();
    }

    public void addParkingSPot(ParkingSpot spot) {
        parking.add(spot);
    }

    public boolean removeParkingSpot(ParkingSpot ps) {
        return this.parking.remove(ps);
    }

    public Optional<ParkingSpot> findParkingSpot(ParkingStrategyService ps, Vehicle.VehicleType vehicleType) {
        return ps.findParkingSpot(parking, vehicleType);
    }

    public boolean parkVehicle(Vehicle v) {
        for (ParkingSpot spot : this.parking) {
            if (spot.free()) {
                return spot.occupy(v);
            }
        }

        return false;
    }

}
