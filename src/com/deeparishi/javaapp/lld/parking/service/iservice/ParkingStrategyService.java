package com.deeparishi.javaapp.lld.parking.service.iservice;

import com.deeparishi.javaapp.lld.parking.model.ParkingSpot;
import com.deeparishi.javaapp.lld.parking.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategyService {

    Optional<ParkingSpot> findParkingSpot(List<ParkingSpot> parkingSpots, Vehicle.VehicleType type);

}
