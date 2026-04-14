package hotels;

public class SuiteRoom extends AbstractRoom {

    public SuiteRoom(int roomNumber,double price) {
        super(roomNumber, price, 20);
    }
    
	@Override
    public String getRoomDetails() {
        return "Suite Room - Room Number: " + roomNumber + ", Price: $" + price;
    }
}