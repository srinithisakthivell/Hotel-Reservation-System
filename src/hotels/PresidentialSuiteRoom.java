package hotels;

public class PresidentialSuiteRoom extends AbstractRoom {

    public PresidentialSuiteRoom(int roomNumber,double price) {
        super(roomNumber, price, 50);
    }

    @Override
    public String getRoomDetails() {
        return "Presidential Suite Room - Room Number: " + roomNumber + ", Price: $" + price;
    }
}