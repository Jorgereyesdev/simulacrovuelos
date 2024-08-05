package com.riwi.mainmodules;

import com.riwi.controllers.PlaneController;
import com.riwi.entities.Plane;

import java.util.Scanner;

public class MainPlane {
    private PlaneController planeController = new PlaneController();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Create Plane");
            System.out.println("2. Delete Plane");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter model: ");
                        String model = scanner.nextLine();
                        System.out.print("Enter capacity: ");
                        int capacity = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        Plane plane = new Plane(model, capacity);
                        planeController.create(plane);
                        System.out.println("Plane created.");
                    } catch (Exception e) {
                        System.out.println("Error creating plane: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter plane ID to delete: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        planeController.delete(id);
                        System.out.println("Plane deleted.");
                    } catch (Exception e) {
                        System.out.println("Error deleting plane: " + e.getMessage());
                    }
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
