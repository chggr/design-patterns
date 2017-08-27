import java.util.List;
import java.util.Map;

public class PAYGChargingStrategy extends AbstractChargingStrategy {

    private static final double MINUTE_CHARGE = 0.03;
    private static final double TEXT_CHARGE = 0.01;
    private static final double DATA_CHARGE = 0.09;

    @Override
    public double calculateCharges(List<NetworkUsage> usage) {
        final Map<NetworkUsage.Type, Integer> totals = calculateTotals(usage);

        return totals.get(NetworkUsage.Type.CALL) * MINUTE_CHARGE +
               totals.get(NetworkUsage.Type.TEXT) * TEXT_CHARGE +
               totals.get(NetworkUsage.Type.DATA) * DATA_CHARGE;
    }
}
