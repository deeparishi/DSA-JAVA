package com.deeparishi.javaapp.ZohoExam.RailwayReservationSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (true) {
            System.out.println("1. Book a ticket \n2. Cancel a ticket \n3.Available Tickets \n4. Booked Ticket \n5.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter a passenger name, age, birth prefrence (L,M,U) ");
                    String name = sc.nextLine();
                    int age = sc.nextInt();
                    String bithpreference = sc.next();
                    Passenger p = new Passenger(name, bithpreference, age);
                    bookTicket(p);
            }

        }

    }

    private static void bookTicket(Passenger p) {

        TicketBooker booker = new TicketBooker();
        if (TicketBooker.availableWaitingTicket == 0) {
            System.out.println("No tickets available");
            return;
        }
        if (p.birthPreferences.equals('L') && TicketBooker.availableLowerBerth > 0 ||
                p.birthPreferences.equals('M') && TicketBooker.availableMiddleBerth > 0 ||
                p.birthPreferences.equals('U') && TicketBooker.availableUpperBerth > 0) {
            System.out.println("Preferred birth available");
            if (p.birthPreferences.equals('L')) {
                booker.bookTicket(p, (TicketBooker.lowerBerthPosition.get(0)), "L");
                TicketBooker.lowerBerthPosition.remove(0);
                TicketBooker.availableLowerBerth--;
            }

        }

    }
}
