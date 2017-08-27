// The strategy pattern is a behavioral software design pattern that enables
// selecting an algorithm at runtime. It defines a family of algorithms,
// encapsulates each one and makes them interchangeable within that family.
// The client subsequently picks the required algorithm during runtime, based
// on a set of parameters that can change from one execution to the next. The
// client is aware of all available strategies, but each strategy is totally
// independent and unaware of other strategies in the family.
//
// Advantages:
// - Lets the algorithm vary independently from clients that use it.
// - Eliminates conditional statements and encapsulates algorithms in classes.
//
// Disadvantages:
// - Client is aware of all available strategies.
//
// Examples: Comparator
//
// In the example below we simulate the different strategies a mobile network
// operator would use to charge its customers. Each customer can use the
// network by calling, sending texts or surfing the web (CALL, TEXT and DATA).
// The correct strategy / algorithm is subsequently used to charge the customer
// for their network usage according to whether they have signed a contract or
// they are pay as you go (PAYG).
//
// 1) Contract: The customer pays a set fee per month that allows them to use
//              a given amount of minutes, texts and data for "free". All usage
//              exceeding this allowance is charged at high rates.
//
// 2) PAYG: The customer is charged based purely on the amount of minutes,
//          texts and data they have used. There will be no charge if they
//          have not used the network at all for a given month.

public class Strategy {

    private static final boolean testContract_NoUsage() {
        ContractChargingStrategy contract =
            new ContractChargingStrategy(7.5, 100, 1000, 2048);
        Customer customer = new Customer("Luke Skywalker", contract);
        return 7.5 == customer.getCharges();
    }

    private static final boolean testContract_LowUsage() {
        ContractChargingStrategy contract =
            new ContractChargingStrategy(7.5, 100, 1000, 2048);
        Customer customer = new Customer("Han Solo", contract);
        customer.addUsage(new NetworkUsage(NetworkUsage.Type.CALL, 50));
        customer.addUsage(new NetworkUsage(NetworkUsage.Type.TEXT, 500));
        customer.addUsage(new NetworkUsage(NetworkUsage.Type.DATA, 1500));
        return 7.5 == customer.getCharges();
    }

    private static final boolean testContract_HighUsage() {
        ContractChargingStrategy contract =
            new ContractChargingStrategy(7.5, 100, 1000, 2048);
        Customer customer = new Customer("Chewbacca", contract);
        customer.addUsage(new NetworkUsage(NetworkUsage.Type.CALL, 150));
        customer.addUsage(new NetworkUsage(NetworkUsage.Type.TEXT, 1500));
        customer.addUsage(new NetworkUsage(NetworkUsage.Type.DATA, 3000));
        return 140.74 == customer.getCharges();
    }

    private static final boolean testPAYG_NoUsage() {
        PAYGChargingStrategy payg = new PAYGChargingStrategy();
        Customer customer = new Customer("Anakin Skywalker", payg);
        return 0.0 == customer.getCharges();
    }

    private static final boolean testPAYG_WithUsage() {
        PAYGChargingStrategy payg = new PAYGChargingStrategy();
        Customer customer = new Customer("Leila Organa", payg);
        customer.addUsage(new NetworkUsage(NetworkUsage.Type.CALL, 10));
        customer.addUsage(new NetworkUsage(NetworkUsage.Type.TEXT, 100));
        customer.addUsage(new NetworkUsage(NetworkUsage.Type.DATA, 1000));
        return 91.3 == customer.getCharges();
    }

    public static void main(String[] args) {
        int counter = 0;
        if (!testContract_NoUsage()) {
            System.out.println("Contract with no usage test failed!");
            counter++;
        }
        if (!testContract_LowUsage()) {
            System.out.println("Contract with low usage test failed!");
            counter++;
        }
        if (!testContract_HighUsage()) {
            System.out.println("Contract with high usage test failed!");
            counter++;
        }
        if (!testPAYG_NoUsage()) {
            System.out.println("PAYG with no usage test failed!");
            counter++;
        }
        if (!testPAYG_WithUsage()) {
            System.out.println("PAYG with usage test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

