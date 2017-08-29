import java.util.ArrayList;
import java.util.List;

// The template method pattern is a behavioral software design pattern that
// uses an abstract class to define the skeleton of an algorithm, deferring
// some of its steps to subclasses. Steps of the algorithm that are considered
// invariant are implemented inside the base class. Steps that will vary are
// given a default or no implementation in the base class and are supplied by
// concrete derived subclasses.
//
// Advantages:
// - Code reuse.
// - Forces an algorithm while allowing some steps to be defined by the user.
//
// Disadvantages:
// - Might create confusing class hierarchy, as the algorithm is divided across
//   multiple classes.
//
// Examples: java.util.Collections.sort(), java.util.AbstractList.indexOf()
//
// In the example below, an investment fund needs to report its trades daily to
// different regulators (European Central Bank, Federal Reserve Bank and
// Financial Conduct Authority). Each regulator has provided their own
// requirements with regards to the header, footer and body of their feed.
// For example the ECB might expect all trades to be reported in a CSV file
// with a specific header. On the contrary the FCA might only require trades
// against LSE to be reported, in a file separated by carets (^).
//
// The algorithm for creating all feeds is the same: filter the trades,
// generate header, body and footer. This has been implemented as a template
// method in AbstractTradeFeed, allowing the different steps of the algorithm
// to be defined in a separate subclass per regulator. The overall algorithm
// remains the same and any regulator-specific requirements are implemented in
// the relevant subclass.

public class TemplateMethod {

    private static boolean testEcbTradeFeed() {
        EcbTradeFeed feed = new EcbTradeFeed();
        return ("European Central Bank Trade Feed\n" + 
                "TRADE_ID,RIC,PRICE,QUANTITY\n" +
                "1,VOD.L,217.0,10\n" +
                "2,AAPL.OQ,162.5,20\n" + 
                "3,RBS.L,252.4,14\n" +
                "RECORD_COUNT:3\n").equals(feed.generate(getTrades()));
    }

    private static boolean testFedTradeFeed() {
        FedTradeFeed feed = new FedTradeFeed();
        return ("Federal Reserve Bank Trade Feed\n" +
                "TRADE_ID~RIC~QUANTITY\n" +
                "1~VOD.L~10\n" +
                "2~AAPL.OQ~20\n" +
                "3~RBS.L~14\n" +
                "FEED_SIZE:3\n").equals(feed.generate(getTrades()));
    }

    private static boolean testFcaTradeFeed() {
        FcaTradeFeed feed = new FcaTradeFeed();
        return ("Financial Conduct Authority Trade Feed\n" +
                "TRADE_ID^STOCK_CODE^AMOUNT\n" +
                "1^VOD.L^2170.0\n" +
                "3^RBS.L^3533.6\n" +
                "TOTAL_COUNT:2\n").equals(feed.generate(getTrades()));
    }

    private static List<Trade> getTrades() {
        List<Trade> trades = new ArrayList<>();
        trades.add(new Trade(1, "VOD.L", 217.0, 10));
        trades.add(new Trade(2, "AAPL.OQ", 162.5, 20));
        trades.add(new Trade(3, "RBS.L", 252.4, 14));
        return trades;
    }

    public static void main(String[] args) {
        int counter = 0;
        if (!testEcbTradeFeed()) {
            System.out.println("ECB trade feed test failed!");
            counter++;
        }
        if (!testFedTradeFeed()) {
            System.out.println("Fed trade feed test failed!");
            counter++;
        }
        if (!testFcaTradeFeed()) {
            System.out.println("FCA trade feed test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

