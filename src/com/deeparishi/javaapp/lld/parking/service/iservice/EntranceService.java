package com.deeparishi.javaapp.lld.parking.service.iservice;

import com.deeparishi.javaapp.lld.parking.model.Ticket;
import com.deeparishi.javaapp.lld.parking.model.Vehicle;


public interface EntranceService {

    Ticket bookSpotAndGiveTicket(Vehicle vehicle);

}