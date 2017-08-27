import java.util.List;

public interface ChargingStrategy {

    double calculateCharges(List<NetworkUsage> usage);
}

