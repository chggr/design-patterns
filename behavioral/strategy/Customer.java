import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final ChargingStrategy chargingStrategy;
    private final List<NetworkUsage> usage = new ArrayList<>();

    public Customer(String name, ChargingStrategy chargingStrategy) {
        this.name = name;
        this.chargingStrategy = chargingStrategy;
    }

    public String getName() {
        return this.name;
    }

    public void addUsage(NetworkUsage usage) {
        this.usage.add(usage);
    }

    public double getCharges() {
        return chargingStrategy.calculateCharges(usage);
    }
}

