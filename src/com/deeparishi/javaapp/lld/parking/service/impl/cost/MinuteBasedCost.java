package com.deeparishi.javaapp.lld.parking.service.impl.cost;

import com.deeparishi.javaapp.lld.parking.model.Vehicle;
import com.deeparishi.javaapp.lld.parking.service.iservice.CostComputationService;

public class MinuteBasedCost implements CostComputationService {

    private int ratePerMinuteOnTwoWheeler = 1;
    private int ratePerMinuteOnFourWheeler = 2;
    private int ratePerMinuteOnHeavyVehicle = 5;

    public MinuteBasedCost() {}

    public MinuteBasedCost(int twoWheelerCost, int fourWheelerCost, int heavyVehicleCost) {
        this.ratePerMinuteOnTwoWheeler = twoWheelerCost;
        this.ratePerMinuteOnFourWheeler = fourWheelerCost;
        this.ratePerMinuteOnHeavyVehicle = heavyVehicleCost;
    }

    @Override
    public int calculateCostForTicket(Vehicle.VehicleType vt, long parkedDurationMillis) {
        switch (vt) {
            case TWO_WHEELER -> {
                return (int) (this.ratePerMinuteOnTwoWheeler * (parkedDurationMillis / (1000 * 60)));
            }
            case FOUR_WHEELER -> {
                return (int) (this.ratePerMinuteOnFourWheeler * (parkedDurationMillis / (1000 * 60)));
            }
            case HEAVY_VEHICLE -> {
                return (int) (this.ratePerMinuteOnHeavyVehicle * (parkedDurationMillis / (1000 * 60)));
            }
            default -> {
                return 0;
            }
        }
    }

    public int getRatePerMinuteOnTwoWheeler() {
        return ratePerMinuteOnTwoWheeler;
    }

    public void setRatePerMinuteOnTwoWheeler(int ratePerMinuteOnTwoWheeler) {
        this.ratePerMinuteOnTwoWheeler = ratePerMinuteOnTwoWheeler;
    }

    public int getRatePerMinuteOnFourWheeler() {
        return ratePerMinuteOnFourWheeler;
    }

    public void setRatePerMinuteOnFourWheeler(int ratePerMinuteOnFourWheeler) {
        this.ratePerMinuteOnFourWheeler = ratePerMinuteOnFourWheeler;
    }

    public int getRatePerMinuteOnHeavyVehicle() {
        return ratePerMinuteOnHeavyVehicle;
    }

    public void setRatePerMinuteOnHeavyVehicle(int ratePerMinuteOnHeavyVehicle) {
        this.ratePerMinuteOnHeavyVehicle = ratePerMinuteOnHeavyVehicle;
    }
}
