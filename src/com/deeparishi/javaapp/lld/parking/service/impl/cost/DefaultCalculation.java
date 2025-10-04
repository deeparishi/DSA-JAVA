package com.deeparishi.javaapp.lld.parking.service.impl.cost;

import com.deeparishi.javaapp.lld.parking.model.Vehicle;
import com.deeparishi.javaapp.lld.parking.service.iservice.CostComputationService;

public class DefaultCalculation implements CostComputationService {

    private int twoWheelerCost = 50;
    private int fourWheelerCost = 150;
    private int heavyVehicleCost = 500;

    public DefaultCalculation () {}

    public DefaultCalculation(int twoWheelerCost, int fourWheelerCost, int heavyVehicleCost) {
        this.twoWheelerCost = twoWheelerCost;
        this.fourWheelerCost = fourWheelerCost;
        this.heavyVehicleCost = heavyVehicleCost;
    }

    @Override
    public int calculateCostForTicket(Vehicle.VehicleType vt, long parkedDurationMillis) {
        switch (vt) {
            case TWO_WHEELER -> {
                return twoWheelerCost;
            }
            case FOUR_WHEELER -> {
                return fourWheelerCost;
            }
            case HEAVY_VEHICLE ->
            {
                return heavyVehicleCost;
            }
            default -> {
                return 0;
            }
        }
    }

    public int getTwoWheelerCost() {
        return twoWheelerCost;
    }

    public void setTwoWheelerCost(int twoWheelerCost) {
        this.twoWheelerCost = twoWheelerCost;
    }

    public int getFourWheelerCost() {
        return fourWheelerCost;
    }

    public void setFourWheelerCost(int fourWheelerCost) {
        this.fourWheelerCost = fourWheelerCost;
    }

    public int getHeavyVehicleCost() {
        return heavyVehicleCost;
    }

    public void setHeavyVehicleCost(int heavyVehicleCost) {
        this.heavyVehicleCost = heavyVehicleCost;
    }
}
