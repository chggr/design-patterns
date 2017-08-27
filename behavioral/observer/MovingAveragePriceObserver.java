import java.util.HashMap;
import java.util.Map;

public class MovingAveragePriceObserver implements StockPriceObserver {

    private final Map<String, Double> averagePrices = new HashMap<>();
    private final StockPriceStream stream;
    private final int size;

    public MovingAveragePriceObserver(StockPriceStream stream, int size) {
        this.stream = stream;
        this.size = size;
        stream.addObserver(this);
    }

    public void update() {
        StockPriceEvent event = stream.getEvent();
        Double average = averagePrices.get(event.getStockCode());
        averagePrices.put(event.getStockCode(), average == null ?
            event.getStockPrice() :
            (average * (size - 1) + event.getStockPrice()) / size);
    }

    public Double getAveragePrice(String stockCode) {
        return averagePrices.get(stockCode);
    }
}

