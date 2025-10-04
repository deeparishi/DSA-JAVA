package com.deeparishi.javaapp.lld.parking.service.iservice;

import com.deeparishi.javaapp.lld.parking.model.Vehicle;

public interface CostComputationService {

    int calculateCostForTicket(Vehicle.VehicleType vt, long parkedDurationMillis);

}
