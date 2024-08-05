package com.riwi;

import com.riwi.mainmodules.MainFlight;
import com.riwi.mainmodules.MainPassenger;
import com.riwi.mainmodules.MainPlane;
import com.riwi.mainmodules.MainReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Manage Planes");
            System.out.println("2. Manage Flights");
            System.out.println("3. Manage Reservations");
            System.out.println("4. Manage Passengers");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    new MainPlane().run();
                    break;
                case 2:
                    new MainFlight().run();
                    break;
                case 3:
                    new MainReservation().run();
                    break;
                case 4:
                    new MainPassenger().run();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
