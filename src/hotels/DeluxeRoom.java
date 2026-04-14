package hotels;

public class DeluxeRoom extends AbstractRoom {

    public DeluxeRoom(int roomNumber, double price) {
        super(roomNumber, price, 30);
    }

    @Override
    public String getRoomDetails() {
        return "Deluxe Room - Room Number: " + roomNumber + ", Price: $" + price;
    }
}