package com.deeparishi.javaapp.lld.parking;

import com.deeparishi.javaapp.lld.parking.model.*;
import com.deeparishi.javaapp.lld.parking.service.impl.*;
import com.deeparishi.javaapp.lld.parking.service.impl.cost.HourlyBasedStrategy;
import com.deeparishi.javaapp.lld.parking.service.impl.spot.*;
import com.deeparishi.javaapp.lld.parking.service.iservice.*;

import java.util.*;

public class ParkingApplication {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Map<Integer, Vehicle.VehicleType> VEHICLE_TYPE_LOOKUP = new LinkedHashMap<>();
    private static final Map<String, Ticket> ACTIVE_TICKETS = new HashMap<>();
    private static final List<Ticket> HISTORY = new ArrayList<>();

    private static final int FLOORS = 5;
    private static final int TW_SPOTS_PER_FLOOR = 50;
    private static final int FW_SPOTS_PER_FLOOR = 50;
    private static final int HV_SPOTS_PER_FLOOR = 25;

    public static void main(String[] args) {

        initializeVehicleTypeLookup();
        ParkingSpotManager spotManager = createParkingStructure();
        CostComputationService costStrategy = new HourlyBasedStrategy();
        EntranceService entranceService = new EntranceServiceImpl(spotManager, costStrategy);

        while (true) {
            printMenu();
            int choice = readIntInput("Choose option: ");

            switch (choice) {
                case 1 -> handleBooking(entranceService);
                case 2 -> handleExit(costStrategy);
                case 3 -> showSpots(spotManager, true);
                case 4 -> showHistory();
                case 5 -> showAllSpots(spotManager);
                case 6 -> showSpots(spotManager, false);
                case 0 -> {
                    System.out.println("Exiting application...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void initializeVehicleTypeLookup() {
        int index = 1;
        for (Vehicle.VehicleType type : Vehicle.VehicleType.values()) {
            VEHICLE_TYPE_LOOKUP.put(index++, type);
        }
    }

    private static ParkingSpotManager createParkingStructure() {
        ParkingSpotManager manager = new ParkingSpotManager();

        for (int floor = 0; floor < FLOORS; floor++) {
            for (int i = 0; i < TW_SPOTS_PER_FLOOR; i++) {
                manager.addParkingSPot(new TwoWheelerParkingSpot(
                        generateSpotId("TW", floor, i), floor,
                        i, false,
                        1,
                        90 - i,
                        95 - i)
                );
            }
            for (int i = 0; i < FW_SPOTS_PER_FLOOR; i++) {
                manager.addParkingSPot(new FourWheelerParkingSpot(
                        generateSpotId("FW", floor, i), floor,
                        i, false,
                        1,
                        85 - i,
                        90 - i)
                );
            }
            for (int i = 0; i < HV_SPOTS_PER_FLOOR; i++) {
                manager.addParkingSPot(new HeavyVehicleParkingSpot(
                        generateSpotId("HV", floor, i), floor,
                        i, false,
                        1,
                        80 - i,
                        85 - i)
                );
            }
        }

        return manager;
    }

    private static void printMenu() {
        System.out.println("\n===== Parking System Menu =====");
        System.out.println("1. Book Parking Spot");
        System.out.println("2. Exit & Pay");
        System.out.println("3. Show Available Spots");
        System.out.println("4. Show History");
        System.out.println("5. Show All Spots");
        System.out.println("6. Show Occupied Spots");
        System.out.println("0. Exit Application");
    }

    private static void handleBooking(EntranceService entrance) {
        String vehicleNumber = readInput("Enter vehicle number: ");
        String model = readInput("Enter model: ");
        String color = readInput("Enter color: ");

        System.out.println("Choose vehicle type:");
        VEHICLE_TYPE_LOOKUP.forEach((key, value) -> System.out.printf("%d. %s%n", key, value));

        int typeChoice = readIntInput("Enter your choice: ");
        Vehicle.VehicleType type = VEHICLE_TYPE_LOOKUP.get(typeChoice);

        if (type == null) {
            System.out.println("Invalid vehicle type selection.");
            return;
        }

        Vehicle vehicle = new Vehicle(vehicleNumber, model, color, type);
        Ticket ticket = entrance.bookSpotAndGiveTicket(vehicle);

        if (ticket != null) {
            ACTIVE_TICKETS.put(vehicle.getVehicleNumber(), ticket);
            System.out.println("\n Ticket Issued:");
            System.out.printf("  Ticket ID: %s%n", ticket.getId());
            System.out.printf("  Spot ID: %s | Floor: %d%n", ticket.getParkingSpot().getSpotName(), ticket.getFloor());
        } else {
            System.out.printf("No available spot for vehicle type: %s%n", type);
        }
    }

    private static void handleExit(CostComputationService costStrategy) {
        String vehicleNumber = readInput("Enter vehicle number to exit: ");

        Ticket ticket = ACTIVE_TICKETS.get(vehicleNumber);
        if (ticket == null) {
            System.out.println("No active ticket found for this vehicle.");
            return;
        }

        ExitService exitService = new ExitServiceImpl(ticket, costStrategy);
        int price = exitService.getPrice(ticket.getVehicle());

        System.out.printf("Amount to pay: ₹%d%n", price);
        String confirmation = readInput("Confirm payment? (y/n): ");

        if (confirmation.equalsIgnoreCase("y")) {
            exitService.pay(price);
            ticket.setExitedAt();
            ACTIVE_TICKETS.remove(vehicleNumber);
            HISTORY.add(ticket);
            System.out.println("Payment successful. Spot vacated.");
        } else {
            System.out.println("Payment cancelled.");
        }
    }

    private static void showSpots(ParkingSpotManager manager, boolean available) {

        System.out.printf("%n=== %s Parking Spots ===%n", available ? "Available" : "Occupied");

        manager.getParking().stream()
                .filter(spot -> spot.free() == available)
                .forEach(spot -> {
                    String vehicleInfo = spot.free() ? "" :
                            String.format(" | Occupied by: %s",
                                    Optional.ofNullable(spot.getVehicle())
                                            .map(Vehicle::getVehicleNumber)
                                            .orElse("Unknown")
                            );

                    System.out.printf("Spot: %s | Type: %s | Floor: %d | %s%s%n",
                            spot.getSpotName(),
                            getVehicleType(spot),
                            spot.getFloorNo(),
                            spot.free() ? "Available" : "Occupied",
                            vehicleInfo);
                });
    }

    private static void showAllSpots(ParkingSpotManager manager) {
        System.out.println("\n=== All Parking Spots ===");

        manager.getParking().forEach(spot -> {
            String type = getVehicleType(spot);
            String status = spot.free() ? "Available" : "Occupied";
            String vehicleNumber = spot.free() ? "" : STR." | Occupied By: \{spot.getVehicle().getVehicleNumber()}";

            System.out.printf("Spot ID: %s | Type: %s | Floor: %d | %s%s%n",
                    spot.getSpotName(), type, spot.getFloorNo(), status, vehicleNumber);
        });
    }

    private static void showHistory() {
        System.out.println("\n=== Parking History ===");
        if (HISTORY.isEmpty()) {
            System.out.println("No history found.");
            return;
        }

        HISTORY.forEach(ticket -> {
            System.out.println("-----------");
            System.out.printf("Ticket ID: %s%n", ticket.getId());
            System.out.printf("Vehicle: %s (%s)%n", ticket.getVehicle().getVehicleNumber(), ticket.getVehicle().getVehicleType());
            System.out.printf("Spot: %s | Floor: %d%n", ticket.getParkingSpot().getSpotName(), ticket.getFloor());
            System.out.printf("Entered: %s | Exited: %s%n", ticket.getEnteredAt(), ticket.getExitedAt());
            System.out.printf("Total Paid: ₹%d%n", ticket.getPrice());
        });
    }

    private static String generateSpotId(String prefix, int floor, int index) {
        return String.format("%s-%c%d", prefix, (char) ('A' + floor), index);
    }

    private static int readIntInput(String prompt) {
        System.out.print(prompt);
        while (!SCANNER.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            SCANNER.next();
        }
        int value = SCANNER.nextInt();
        SCANNER.nextLine();
        return value;
    }

    private static String readInput(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine();
    }

    private static String getVehicleType(ParkingSpot spot) {
        if (spot instanceof TwoWheelerParkingSpot) return Vehicle.VehicleType.TWO_WHEELER.name();
        if (spot instanceof FourWheelerParkingSpot) return Vehicle.VehicleType.FOUR_WHEELER.name();
        if (spot instanceof HeavyVehicleParkingSpot) return Vehicle.VehicleType.HEAVY_VEHICLE.name();
        return "UNKNOWN";
    }
}
