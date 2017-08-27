// The observer pattern is a behavioral software design pattern that defines a
// one-to-many dependency between objects so that when the state of one object
// changes (Subject), all its dependents (Observers) are notified and updated
// automatically. This pattern is often used to implement distributed event
// handling systems in event-driven software. It also plays a key role in the
// View part of the Model-View-Controller (MVC) software architectural pattern.
//
// The Subject holds the data model and delegates "view" functionality to
// decoupled Observer objects. Observers register themselves with the Subject
// upon instantiation. Whenever the Subject's state changes, it broadcasts that
// it has changed to all registered Observers and each Observer queries the
// Subject for the subset of the state that is responsible for monitoring. This
// allows the type and number of Observers to be configured dynamically.
//
// Advantages:
// - Loose coupling between Subject and Observers.
// - New observers can be added or removed from a Subject dynamically.
//
// Disadvantages:
// - May cause memory leaks if Subject maintains hard references to Observers.
//   (Lapsed Listener Problem).
// - Often hard to find what part of the state changed and triggered an update.
//
// Examples: Observer, EventListener
//
// In the example below, the StockPriceStream is the Subject that holds the
// most recent StockPriceEvent. Once a new StockPriceEvent is published, the
// StockPriceStream modifies its state and notifies all StockPriceObservers.
// The following three StockPriceObservers have been created, that receive
// and handle StockPriceEvents.
//
// 1) MaxPriceObserver: Calculates maximum price for each stock.
// 2) MinPriceObserver: Calculates minimum price for each stock.
// 3) MovingAveragePriceObserver: Calculates the moving average for each stock.

public class Observer {

    private static boolean testMaxPriceObserver(MaxPriceObserver observer) {
        return 223.04 == observer.getMaxPrice("VOD.L") &&
               279.98 == observer.getMaxPrice("RBS.L") &&
               null == observer.getMaxPrice("FDSA.L");
    }

    private static boolean testMinPriceObserver(MinPriceObserver observer) {
        return 221.13 == observer.getMinPrice("VOD.L") &&
               278.33 == observer.getMinPrice("RBS.L") &&
               null == observer.getMinPrice("FDSA.L");
    }

    private static boolean testMovingAveragePriceObserver(
            MovingAveragePriceObserver observer) {
        return 221.9445536 == observer.getAveragePrice("VOD.L") &&
               279.205088 == observer.getAveragePrice("RBS.L") &&
               null == observer.getAveragePrice("FDSA.L");
    }

    public static void main(String[] args) {
        StockPriceStream stream = new StockPriceStream();
        MaxPriceObserver maxPriceObserver = new MaxPriceObserver(stream);
        MinPriceObserver minPriceObserver = new MinPriceObserver(stream);
        MovingAveragePriceObserver avgPriceObserver = 
            new MovingAveragePriceObserver(stream, 5);

        stream.publish(new StockPriceEvent("VOD.L", 221.32));
        stream.publish(new StockPriceEvent("RBS.L", 279.21));
        stream.publish(new StockPriceEvent("VOD.L", 222.77));
        stream.publish(new StockPriceEvent("RBS.L", 278.93));
        stream.publish(new StockPriceEvent("VOD.L", 223.04));
        stream.publish(new StockPriceEvent("VOD.L", 222.93));
        stream.publish(new StockPriceEvent("RBS.L", 278.33));
        stream.publish(new StockPriceEvent("VOD.L", 222.54));
        stream.publish(new StockPriceEvent("RBS.L", 279.10));
        stream.publish(new StockPriceEvent("VOD.L", 221.98));
        stream.publish(new StockPriceEvent("VOD.L", 221.13));
        stream.publish(new StockPriceEvent("RBS.L", 279.98));

        int counter = 0;
        if (!testMaxPriceObserver(maxPriceObserver)) {
            System.out.println("Max price observer test failed!");
            counter++;
        }
        if (!testMinPriceObserver(minPriceObserver)) {
            System.out.println("Min price observer test failed!");
            counter++;
        }
        if (!testMovingAveragePriceObserver(avgPriceObserver)) {
            System.out.println("Average price observer test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

