package com.riwi.mainmodules;

import com.riwi.controllers.PassengerController;
import com.riwi.entities.Passenger;

import java.util.List;
import java.util.Scanner;

public class MainPassenger {
    private PassengerController passengerController = new PassengerController();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Create Passenger");
            System.out.println("2. Delete Passenger");
            System.out.println("3. Update Passenger");
            System.out.println("4. Find Passengers by Name");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastname = scanner.nextLine();
                    System.out.print("Enter document: ");
                    String document = scanner.nextLine();
                    Passenger passenger = new Passenger(name, lastname, document);
                    passengerController.create(passenger);
                    System.out.println("Passenger created.");
                    break;
                case 2:
                    System.out.print("Enter passenger ID to delete: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    passengerController.delete(id);
                    System.out.println("Passenger deleted.");
                    break;
                case 3:
                    System.out.print("Enter passenger ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new last name: ");
                    String newLastname = scanner.nextLine();
                    System.out.print("Enter new document: ");
                    String newDocument = scanner.nextLine();
                    Passenger updatedPassenger = new Passenger(updateId, newName, newLastname, newDocument);

                    passengerController.update(updatedPassenger);
                    System.out.println("Passenger updated.");
                    break;
                case 4:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    List<Passenger> passengers = passengerController.findByName(searchName);
                    passengers.forEach(System.out::println);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
