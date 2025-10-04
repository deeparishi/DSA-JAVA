package com.deeparishi.javaapp.lld.parking.service.impl.cost;

import com.deeparishi.javaapp.lld.parking.model.Vehicle;
import com.deeparishi.javaapp.lld.parking.service.iservice.CostComputationService;

public class HourlyBasedStrategy implements CostComputationService {

    private int ratePerHourOnTwoWheeler = 60;
    private int ratePerHourOnFourWheeler = 120;
    private int ratePerHourOnHeavyVehicle = 300;

    public HourlyBasedStrategy() {}

    public HourlyBasedStrategy(int twoWheelerCost, int fourWheelerCost, int heavyVehicleCost) {
        this.ratePerHourOnTwoWheeler = twoWheelerCost;
        this.ratePerHourOnFourWheeler = fourWheelerCost;
        this.ratePerHourOnHeavyVehicle = heavyVehicleCost;
    }

    @Override
    public int calculateCostForTicket(Vehicle.VehicleType vt, long parkedDurationMillis) {
        switch (vt) {
            case TWO_WHEELER -> {
                return (int) (ratePerHourOnTwoWheeler * (parkedDurationMillis/ 1000 * 60 * 60));
            }

            case FOUR_WHEELER -> {
                return (int) (ratePerHourOnFourWheeler * (parkedDurationMillis/ 1000 * 60 * 60));
            }

            case HEAVY_VEHICLE -> {
                return (int) (ratePerHourOnHeavyVehicle * (parkedDurationMillis/ 1000 * 60 * 60));
            }
            default -> {
                return 0;
            }
        }
    }

    public int getRatePerHourOnTwoWheeler() {
        return ratePerHourOnTwoWheeler;
    }

    public void setRatePerHourOnTwoWheeler(int ratePerHourOnTwoWheeler) {
        this.ratePerHourOnTwoWheeler = ratePerHourOnTwoWheeler;
    }

    public int getRatePerHourOnFourWheeler() {
        return ratePerHourOnFourWheeler;
    }

    public void setRatePerHourOnFourWheeler(int ratePerHourOnFourWheeler) {
        this.ratePerHourOnFourWheeler = ratePerHourOnFourWheeler;
    }

    public int getRatePerHourOnHeavyVehicle() {
        return ratePerHourOnHeavyVehicle;
    }

    public void setRatePerHourOnHeavyVehicle(int ratePerHourOnHeavyVehicle) {
        this.ratePerHourOnHeavyVehicle = ratePerHourOnHeavyVehicle;
    }
}
