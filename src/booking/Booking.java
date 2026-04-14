package booking;

import hotels.Room;

public interface Booking {
    boolean createBooking(Room room, String customerName);
    boolean cancelBooking();
    String getBookingDetails();
    Room getRoom();
}