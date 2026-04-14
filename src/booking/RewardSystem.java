package booking;

import java.util.HashMap;
import java.util.Map;

public class RewardSystem {
    private Map<String, Integer> customerRewards;

    public RewardSystem() {
        customerRewards = new HashMap<>();
    }

    public void addBooking(String customerName, int rewardPoints) {
        customerRewards.put(customerName, customerRewards.getOrDefault(customerName, 0) + rewardPoints);
    }

    public int getRewardPoints(String customerName) {
        return customerRewards.getOrDefault(customerName, 0);
    }
}