package hotels;

public interface Room {
    int getRoomNumber();
    double getPrice();
    String getRoomDetails();
    boolean bookRoom();
    boolean cancelRoom();
    boolean isBooked();
    void setRating(double rating);
    double getRating();
    int getRewardPoints();
}