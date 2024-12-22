package com.deeparishi.javaapp.ZohoExam.RailwayReservationSystem;

import java.util.*;

public class TicketBooker {

    static int availableLowerBerth = 1;
    static int availableUpperBerth = 1;
    static int availableMiddleBerth = 1;
    static int availableRacTicket = 1;
    static int availableWaitingTicket = 1;

    static Queue<Integer> waitingList = new LinkedList<>();
    static Queue<Integer> racTickets = new LinkedList<>();
    static List<Integer> bookedTicketList = new ArrayList<>();

    static List<Integer> lowerBerthPosition = new ArrayList<>(Arrays.asList(1));
    static List<Integer> midddleBerthPosition = new ArrayList<>(Arrays.asList(1));
    static List<Integer> upperBerthPosition = new ArrayList<>(Arrays.asList(1));
    static List<Integer> racPositions = new ArrayList<>(Arrays.asList(1));
    static List<Integer> waitingListPositions = new ArrayList<>(Arrays.asList(1));

    static Map<Integer, Passenger> passengers = new HashMap<>();


    public void bookTicket(Passenger p, int birthinfo, String allotedBirth) {
    }
}
