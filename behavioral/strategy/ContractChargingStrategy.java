import java.util.List;
import java.util.Map;

public class ContractChargingStrategy extends AbstractChargingStrategy {

    private static final double MINUTE_CHARGE = 0.08;
    private static final double TEXT_CHARGE = 0.03;
    private static final double DATA_CHARGE = 0.12;

    private final double initialCharge;
    private final int freeMinutes;
    private final int freeTexts;
    private final int freeData;

    public ContractChargingStrategy(double initialCharge,
                                    int freeMinutes,
                                    int freeTexts,
                                    int freeData) {

        this.initialCharge = initialCharge;
        this.freeMinutes = freeMinutes;
        this.freeTexts = freeTexts;
        this.freeData = freeData;
    }

    @Override
    public double calculateCharges(List<NetworkUsage> usage) {
        final Map<NetworkUsage.Type, Integer> totals = calculateTotals(usage);

        int minutes = totals.get(NetworkUsage.Type.CALL) - freeMinutes;
        int texts = totals.get(NetworkUsage.Type.TEXT) - freeTexts;
        int data = totals.get(NetworkUsage.Type.DATA) - freeData;

        double chargeAmount = initialCharge;
        chargeAmount += minutes > 0 ? minutes * MINUTE_CHARGE : 0.0;
        chargeAmount += texts > 0 ? texts * TEXT_CHARGE : 0.0;
        chargeAmount += data > 0 ? data * DATA_CHARGE : 0.0;
        return chargeAmount;
    }
}

