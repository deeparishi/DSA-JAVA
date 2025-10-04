package com.deeparishi.javaapp.lld.parking.service.impl;

import com.deeparishi.javaapp.lld.parking.model.ParkingSpot;
import com.deeparishi.javaapp.lld.parking.model.ParkingSpotManager;
import com.deeparishi.javaapp.lld.parking.model.Ticket;
import com.deeparishi.javaapp.lld.parking.model.Vehicle;
import com.deeparishi.javaapp.lld.parking.service.impl.cost.DefaultCalculation;
import com.deeparishi.javaapp.lld.parking.service.impl.strategy.NearToElevatorParkingStrategy;
import com.deeparishi.javaapp.lld.parking.service.iservice.CostComputationService;
import com.deeparishi.javaapp.lld.parking.service.iservice.EntranceService;

import java.time.LocalDateTime;

public class EntranceServiceImpl implements EntranceService {

    private final ParkingSpotManager parkingSpotManager;
    private final CostComputationService costComputation;

    public EntranceServiceImpl(ParkingSpotManager parkingSpotManager,
                               CostComputationService costComputation) {
        this.parkingSpotManager = parkingSpotManager;
        this.costComputation = costComputation;
    }


    @Override
    public Ticket bookSpotAndGiveTicket(Vehicle vehicle) {

        ParkingSpot spot = parkingSpotManager.findParkingSpot(new NearToElevatorParkingStrategy(), vehicle.getVehicleType())
                .orElseThrow(() -> new RuntimeException("Parking was full!"));

        boolean flag = parkingSpotManager.parkVehicle(vehicle);

        if(!flag)
            throw new RuntimeException("Parking was full!");

        if (costComputation instanceof DefaultCalculation) {
            int price = costComputation.calculateCostForTicket(vehicle.getVehicleType(), 0);
            return new Ticket(spot.getFloorNo(), price, LocalDateTime.now(), vehicle, spot);
        }

        return new Ticket(spot.getFloorNo(), LocalDateTime.now(), vehicle, spot);
    }

}
