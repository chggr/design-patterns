import java.util.Map.Entry;

public class DeliveryFactory {

    private final double standardThreshold;
    private final double priorityThreshold;

    public DeliveryFactory(double standardThreshold, double priorityThreshold) {
        this.standardThreshold = standardThreshold;
        this.priorityThreshold = priorityThreshold;
    }

    public Delivery getDelivery(Order order) {
        if (order.isExpedited()) {
            return new PriorityDelivery();
        }

        double value = calculateValue(order);
        if (value >= priorityThreshold) {
            return new PriorityDelivery();
        } else if (value >= standardThreshold) {
            return new StandardDelivery();
        } else {
            return new FreeDelivery();
        }
    }

    private double calculateValue(Order order) {
        double value = 0;
        for (Entry<Product, Integer> item : order.getCart().entrySet()) {
            value += item.getKey().getPrice() * item.getValue();
        }
        return value;
    }
}

