package com.riwi.mainmodules;

import com.riwi.controllers.ReservationController;
import com.riwi.entities.Reservation;

import java.util.List;
import java.util.Scanner;

public class MainReservation {
    private ReservationController reservationController = new ReservationController();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Create Reservation");
            System.out.println("2. Delete Reservation");
            System.out.println("3. Update Reservation");
            System.out.println("4. Find Reservations by Flight");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter reservation date (YYYY-MM-DD): ");
                    String reservationDate = scanner.nextLine();
                    System.out.print("Enter seat: ");
                    int seat = scanner.nextInt();  // Changed to Integer
                    System.out.print("Enter passenger ID: ");
                    int passengerId = scanner.nextInt();
                    System.out.print("Enter flight ID: ");
                    int flightId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Reservation reservation = new Reservation(null, reservationDate, seat, passengerId, flightId);
                    reservationController.create(reservation);
                    System.out.println("Reservation created.");
                    break;
                case 2:
                    System.out.print("Enter reservation ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    reservationController.delete(deleteId);
                    System.out.println("Reservation deleted.");
                    break;
                case 3:
                    System.out.print("Enter reservation ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new reservation date (YYYY-MM-DD): ");
                    String newReservationDate = scanner.nextLine();
                    System.out.print("Enter new seat: ");
                    int newSeat = scanner.nextInt();  // Changed to Integer
                    System.out.print("Enter new passenger ID: ");
                    int newPassengerId = scanner.nextInt();
                    System.out.print("Enter new flight ID: ");
                    int newFlightId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Reservation updatedReservation = new Reservation(updateId, newReservationDate, newSeat, newPassengerId, newFlightId);
                    reservationController.update(updatedReservation);
                    System.out.println("Reservation updated.");
                    break;
                case 4:
                    System.out.print("Enter flight ID to find reservations: ");
                    int searchFlightId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    List<Reservation> reservations = reservationController.findByFlight(searchFlightId);
                    reservations.forEach(System.out::println);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
