package ui;

import model.Payment;
import service.PaymentService;
import service.ReservationService;
import service.RoomService;
import util.CsvManager;

import java.util.Scanner;

public class Menu {
    private final RoomService roomService;
    private final ReservationService reservationService;
    private final PaymentService paymentService;
    private final Scanner scanner;

    public Menu() {
        this.roomService = new RoomService();
        this.reservationService = new ReservationService();
        this.paymentService = new PaymentService();
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Welcome to Hotel Reservation System");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservation");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewReservation();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewAvailableRooms() {
        System.out.print("Enter room type (single/double/suite): ");
        String type = scanner.nextLine();
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkInDate = scanner.nextLine();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOutDate = scanner.nextLine();

        var availableRooms = roomService.getAvailableRooms(type, checkInDate, checkOutDate);
        if (availableRooms.isEmpty()) {
            System.out.println("No available rooms for the selected type and dates.");
        } else {
            availableRooms.forEach(System.out::println);
        }
    }

    private void makeReservation() {
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkInDate = scanner.nextLine();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOutDate = scanner.nextLine();
        System.out.print("Enter payment card number: ");
        String cardNumber = scanner.nextLine();
        System.out.print("Enter card holder name: ");
        String cardHolderName = scanner.nextLine();
        System.out.print("Enter card expiry date (MM/YY): ");
        String expiryDate = scanner.nextLine();
        System.out.print("Enter card CVV: ");
        String cvv = scanner.nextLine();
        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        var payment = new Payment(cardNumber, cardHolderName, expiryDate, cvv, amount);
        var reservation = reservationService.createReservation(roomNumber, guestName, checkInDate, checkOutDate, payment);

        if (reservation != null) {
            System.out.println("Reservation created successfully: " + reservation);
            roomService.updateRoomAvailability(roomNumber, false);
        } else {
            System.out.println("Failed to create reservation. Please try again.");
        }
    }

    private void viewReservation() {
        System.out.print("Enter reservation ID: ");
        String reservationId = scanner.nextLine();

        var reservation = reservationService.getReservationById(reservationId);
        if (reservation != null) {
            System.out.println("Reservation details: " + reservation);
        } else {
            System.out.println("Reservation not found.");
        }
    }

    public static void main(String[] args) {
        Menu mainMenu = new Menu();
        mainMenu.displayMenu();
    }
}
