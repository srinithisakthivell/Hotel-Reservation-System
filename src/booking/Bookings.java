package booking;

import hotels.Room;

public class Bookings implements Booking {
    private Room room;
    private String customerName;
    private static RewardSystem rewardSystem = new RewardSystem();

    @Override
    public boolean createBooking(Room room, String customerName) {
        if (room.bookRoom()) {
            this.room = room;
            this.customerName = customerName;
            rewardSystem.addBooking(customerName, room.getRewardPoints());
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelBooking() {
        if (room != null && room.cancelRoom()) {
            room = null;
            customerName = null;
            return true;
        }
        return false;
    }

    @Override
    public String getBookingDetails() {
        if (room == null) {
            return "No active booking found.";
        }

        return String.format(
            "Booking Details:%nCustomer: %s%n%s%nReward Points: %d",
            customerName,
            room.getRoomDetails(),
            rewardSystem.getRewardPoints(customerName)
        );
    }

    @Override
    public Room getRoom() {
        return room;
    }

    public String getCustomerName() {
        return customerName;
    }
}