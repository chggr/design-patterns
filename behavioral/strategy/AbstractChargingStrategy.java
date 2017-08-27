import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.List;
import java.util.Map;

public abstract class AbstractChargingStrategy implements ChargingStrategy {

    @Override
    public abstract double calculateCharges(List<NetworkUsage> usage);

    Map<NetworkUsage.Type, Integer> calculateTotals(List<NetworkUsage> usage) {
        final Map<NetworkUsage.Type, Integer> totals = usage.stream().collect(
            groupingBy(NetworkUsage::getType, summingInt(NetworkUsage::getUnits)));

        totals.computeIfAbsent(NetworkUsage.Type.CALL, k -> 0);
        totals.computeIfAbsent(NetworkUsage.Type.TEXT, k -> 0);
        totals.computeIfAbsent(NetworkUsage.Type.DATA, k -> 0);
        return totals;
    }
}

