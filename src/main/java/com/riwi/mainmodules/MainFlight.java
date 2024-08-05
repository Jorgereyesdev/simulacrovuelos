package com.riwi.mainmodules;

import com.riwi.controllers.FlightController;
import com.riwi.entities.Flight;

import java.sql.Time;
import java.util.List;
import java.util.Scanner;

public class MainFlight {
    private FlightController flightController = new FlightController();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Create Flight");
            System.out.println("2. Delete Flight");
            System.out.println("3. Update Flight");
            System.out.println("4. Find Flights by Destination");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter departure date (YYYY-MM-DD): ");
                    String departureDate = scanner.nextLine();
                    System.out.print("Enter departure hour (HH:MM:SS): ");
                    String departureHourStr = scanner.nextLine();
                    Time departureHour = Time.valueOf(departureHourStr);  // Convert string to Time
                    System.out.print("Enter plane ID: ");
                    int planeId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Flight flight = new Flight(destination, departureDate, departureHour, planeId);
                    flightController.create(flight);
                    System.out.println("Flight created.");
                    break;
                case 2:
                    System.out.print("Enter flight ID to delete: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    flightController.delete(id);
                    System.out.println("Flight deleted.");
                    break;
                case 3:
                    System.out.print("Enter flight ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new destination: ");
                    String newDestination = scanner.nextLine();
                    System.out.print("Enter new departure date (YYYY-MM-DD): ");
                    String newDepartureDate = scanner.nextLine();
                    System.out.print("Enter new departure hour (HH:MM:SS): ");
                    String newDepartureHourStr = scanner.nextLine();
                    Time newDepartureHour = Time.valueOf(newDepartureHourStr);  // Convert string to Time
                    System.out.print("Enter new plane ID: ");
                    int newPlaneId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Flight updatedFlight = new Flight(updateId, newDestination, newDepartureDate, newDepartureHour, newPlaneId);
                    flightController.update(updatedFlight);
                    System.out.println("Flight updated.");
                    break;
                case 4:
                    System.out.print("Enter destination to search: ");
                    String searchDestination = scanner.nextLine();
                    List<Flight> flights = flightController.readByDestination(searchDestination);
                    flights.forEach(System.out::println);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
