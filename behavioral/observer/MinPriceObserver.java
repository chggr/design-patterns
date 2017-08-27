import java.util.HashMap;
import java.util.Map;

public class MinPriceObserver implements StockPriceObserver {

    private final Map<String, Double> minPrices = new HashMap<>();
    private final StockPriceStream stream;

    public MinPriceObserver(StockPriceStream stream) {
        this.stream = stream;
        stream.addObserver(this);
    }

    public void update() {
        StockPriceEvent event = stream.getEvent();
        Double price = minPrices.get(event.getStockCode());
        if (price == null || price > event.getStockPrice()) {
            minPrices.put(event.getStockCode(), event.getStockPrice());
        }
    }

    public Double getMinPrice(String stockCode) {
        return minPrices.get(stockCode);
    }
}

