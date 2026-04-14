package hotels;

public class DoubleRoom extends AbstractRoom {

    public DoubleRoom(int roomNumber, double price) {
        super(roomNumber, price, 10);
    }

    @Override
    public String getRoomDetails() {
        return "Double Room - Room Number: " + roomNumber + ", Price: $" + price;
    }
}