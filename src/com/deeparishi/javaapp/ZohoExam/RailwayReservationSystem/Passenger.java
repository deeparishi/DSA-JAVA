package com.deeparishi.javaapp.ZohoExam.RailwayReservationSystem;

public class Passenger {

    static int id = 1;
    String name;
    int age;
    String birthPreferences;
    int passengerId;
    String alloted;
    int seatnumber;

    Passenger(String name, String birthpreferences, int age) {
        this.name = name;
        this.birthPreferences = birthpreferences;
        this.age = age;
        this.passengerId = id++;
        alloted = "";
        seatnumber = -1;
    }


}
