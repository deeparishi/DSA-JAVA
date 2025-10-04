package com.deeparishi.javaapp.lld.parking.service.impl.strategy;

import com.deeparishi.javaapp.lld.parking.model.ParkingSpot;
import com.deeparishi.javaapp.lld.parking.model.Vehicle;
import com.deeparishi.javaapp.lld.parking.service.impl.spot.FourWheelerParkingSpot;
import com.deeparishi.javaapp.lld.parking.service.impl.spot.HeavyVehicleParkingSpot;
import com.deeparishi.javaapp.lld.parking.service.impl.spot.TwoWheelerParkingSpot;
import com.deeparishi.javaapp.lld.parking.service.iservice.ParkingStrategyService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NearToEscalatorParkingStrategy implements ParkingStrategyService {

    @Override
    public Optional<ParkingSpot> findParkingSpot(List<ParkingSpot> parkingSpots, Vehicle.VehicleType type) {
        return parkingSpots.stream()
                .filter(p -> p.free() && spotMatchesVehicle(p, type))
                .min(Comparator.comparingInt(ParkingSpot::getNearbyDistanceToEscalatorInMeter));

    }

    private boolean spotMatchesVehicle(ParkingSpot spot, Vehicle.VehicleType vt) {
        if (spot instanceof TwoWheelerParkingSpot && vt.equals(Vehicle.VehicleType.TWO_WHEELER))
            return true;

        if (spot instanceof FourWheelerParkingSpot && vt.equals(Vehicle.VehicleType.FOUR_WHEELER))
            return true;

        return spot instanceof HeavyVehicleParkingSpot && vt.equals(Vehicle.VehicleType.HEAVY_VEHICLE);
    }
}
