package hotels;

public class SingleRoom extends AbstractRoom {

    public SingleRoom(int roomNumber, double price) {
        super(roomNumber, price, 5);
    }

    @Override
    public String getRoomDetails() {
        return "Single Room - Room Number: " + roomNumber + ", Price: $" + price;
    }
}