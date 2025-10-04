package com.deeparishi.javaapp.lld.parking.service.impl;

import com.deeparishi.javaapp.lld.parking.model.Ticket;
import com.deeparishi.javaapp.lld.parking.model.Vehicle;
import com.deeparishi.javaapp.lld.parking.service.impl.cost.DefaultCalculation;
import com.deeparishi.javaapp.lld.parking.service.iservice.CostComputationService;
import com.deeparishi.javaapp.lld.parking.service.iservice.ExitService;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExitServiceImpl implements ExitService {

    private final CostComputationService costComputation;
    private final Ticket ticket;

    public ExitServiceImpl(Ticket ticket, CostComputationService costComputation) {
        this.ticket = ticket;
        this.costComputation = costComputation;
    }

    @Override
    public int getPrice(Vehicle vehicle) {

        if (!ticket.getVehicle().equals(vehicle))
            throw new RuntimeException("Red Flag! Ticket and vehicle is not same, check that!");

        if (costComputation instanceof DefaultCalculation)
            return ticket.getPrice();

        LocalDateTime enter = ticket.getEnteredAt();
        LocalDateTime exit = LocalDateTime.now();

        int price = costComputation.calculateCostForTicket(vehicle.getVehicleType(), Duration.between(enter, exit).toMillis());
        ticket.setPrice(price);

        return price;
    }

    @Override
    public String pay(int amount) {
        ticket.getParkingSpot().vacate();
        return "Paid Successfully!";
    }
}