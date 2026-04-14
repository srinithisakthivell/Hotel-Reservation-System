package hotels;

public abstract class AbstractRoom implements Room {
    protected int roomNumber;
    protected double price;
    private boolean isBooked;
    protected double rating;
    protected int rewardPoints;

    public AbstractRoom(int roomNumber, double price, int rewardPoints) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.isBooked = false;
        this.rating = 0.0;
        this.rewardPoints = rewardPoints;
    }

    @Override
    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean bookRoom() {
        if (!isBooked) {
            isBooked = true;
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean cancelRoom() {
        if (isBooked) {
            isBooked = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean isBooked() {
        return isBooked;
    }

    @Override
    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public int getRewardPoints() {
        return rewardPoints;
    }
}