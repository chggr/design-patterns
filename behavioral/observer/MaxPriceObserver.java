import java.util.HashMap;
import java.util.Map;

public class MaxPriceObserver implements StockPriceObserver {

    private final Map<String, Double> maxPrices = new HashMap<>();
    private final StockPriceStream stream;

    public MaxPriceObserver(StockPriceStream stream) {
        this.stream = stream;
        stream.addObserver(this);
    }

    public void update() {
        StockPriceEvent event = stream.getEvent();
        Double price = maxPrices.get(event.getStockCode());
        if (price == null || price < event.getStockPrice()) {
            maxPrices.put(event.getStockCode(), event.getStockPrice());
        }
    }

    public Double getMaxPrice(String stockCode) {
        return maxPrices.get(stockCode);
    }
}

