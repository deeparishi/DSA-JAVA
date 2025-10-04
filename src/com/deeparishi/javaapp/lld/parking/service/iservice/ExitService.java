package com.deeparishi.javaapp.lld.parking.service.iservice;

import com.deeparishi.javaapp.lld.parking.model.Vehicle;

public interface ExitService {

    int getPrice(Vehicle vehicle);

    String pay(int amount);

}
