package main;

import hotels.Room;
import hotels.SingleRoom;
import hotels.DoubleRoom;
import hotels.SuiteRoom;
import hotels.DeluxeRoom;
import hotels.PresidentialSuiteRoom;
import booking.Bookings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Bookings> bookings = new ArrayList<>();
    private static List<String> bookingHistory = new ArrayList<>();
    private static List<Double> customerRatings = new ArrayList<>();

    public static void main(String[] args) {
        initializeRooms();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("\n==========================================");
            System.out.println("🏨 Welcome to the Hotel Reservation System");
            System.out.println("==========================================");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. View Booking History");
            System.out.println("5. Give Customer Rating");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    bookRoom(scanner);
                    break;
                case 3:
                    cancelBooking(scanner);
                    break;
                case 4:
                    viewBookingHistory();
                    break;
                case 5:
                    giveCustomerRating(scanner);
                    break;
                case 6:
                    exit = true;
                    System.out.println("\nThank you for using the Hotel Room Booking System."
                    		+ "\nHave a great day!✨");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }
    
    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("❌ Please enter a valid number.");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
    
    private static void initializeRooms() {
        rooms.add(new SingleRoom(101, 100));
        rooms.add(new DoubleRoom(201, 200));
        rooms.add(new SuiteRoom(301,450));
        rooms.add(new DeluxeRoom(401, 350));
        rooms.add(new PresidentialSuiteRoom(501,1000));
    }

    private static void viewAvailableRooms() {
        System.out.println("\n📋 Room List:");
        for (Room room : rooms) {
            System.out.println(room.getRoomDetails() + " | Status: " + (room.isBooked() ? "Booked" : "Available"));
        }
    }

    private static void bookRoom(Scanner scanner) {
        System.out.println("\n🔢 Enter the room number you want to book: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();

        Room roomToBook = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isBooked()) {
                roomToBook = room;
                break;
            }
        }

        if (roomToBook == null) {
            System.out.println("❌ Room not available or already booked.");
            return;
        }

        System.out.println("Enter your name: ");
        String customerName = scanner.nextLine();

        Bookings booking = new Bookings();
        if (booking.createBooking(roomToBook, customerName)) {
            bookings.add(booking);
            bookingHistory.add("Booked by " + customerName + " -> " + roomToBook.getRoomDetails());
            System.out.println("\n✅ Booking successful!");
            System.out.println(booking.getBookingDetails());
        } else {
            System.out.println("❌ Booking failed!");
        }
    }

    private static void cancelBooking(Scanner scanner) {
        System.out.println("\n🔢 Enter the room number of the booking you want to cancel: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();

        Bookings bookingToCancel = null;
        for (Bookings booking : bookings) {
            if (booking.getRoom() != null && booking.getRoom().getRoomNumber() == roomNumber) {
                bookingToCancel = booking;
                break;
            }
        }

        if (bookingToCancel == null) {
            System.out.println("❌ Booking not found.");
            return;
        }

        String customerName = bookingToCancel.getCustomerName();

        if (bookingToCancel.cancelBooking()) {
            bookings.remove(bookingToCancel);
            bookingHistory.add("Cancelled booking of Room Number: " + roomNumber + " by " + customerName);
            System.out.println("✅ Booking cancelled successfully.");
        } else {
            System.out.println("❌ Cancellation failed.");
        }
    }

    private static void viewBookingHistory() {
        System.out.println("\n📋 Booking History:");
        if (bookingHistory.isEmpty()) {
            System.out.println("❌ No booking done yet.");
        } else {
            for (String record : bookingHistory) {
                System.out.println(record);
            }
        }
    }

    private static void giveCustomerRating(Scanner scanner) {
        System.out.println("\n🔢 Enter room number to rate: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();

        Room targetRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                targetRoom = room;
                break;
            }
        }

        if (targetRoom == null) {
            System.out.println("❌ Room not found.");
            return;
        }

        System.out.println("Enter your rating (1 to 5): ");
        double rating = scanner.nextDouble();
        scanner.nextLine();

        if (rating >= 1.0 && rating <= 5.0) {
            targetRoom.setRating(rating);
            System.out.println("🙏 Thank you! Rating saved for Room " + roomNumber);
        } else {
            System.out.println("❌ Invalid rating. Please enter a value between 1 and 5.");
        }
    }
}