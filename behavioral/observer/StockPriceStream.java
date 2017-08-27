import java.util.ArrayList;
import java.util.List;

public class StockPriceStream {

    private final List<StockPriceObserver> observers = new ArrayList<>();
    private StockPriceEvent event;

    public void addObserver(StockPriceObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(StockPriceObserver observer) {
        this.observers.remove(observer);
    }

    public synchronized void publish(StockPriceEvent event) {
        this.event = event;
        notifyObservers();
    }

    public StockPriceEvent getEvent() {
        return event;
    }

    private void notifyObservers() {
        for (StockPriceObserver observer : observers) {
            observer.update();
        }
    }
}

