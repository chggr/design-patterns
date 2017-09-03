// The factory method pattern is a creational software design pattern that
// allows clients to create objects without having to specify the exact class
// of the object that will be created. This is done by calling the factory
// method instead of instantiating the required object directly via its
// constructor. The factory method will create the required object based on
// the parameters that have been provided to it. The client can use the object
// returned by the factory method without knowing which subclass has been used
// to create it.
//
// The factory method pattern is often used when creating an object:
// - requires complex logic that is not appropriate to include within the class
//   that will use it.
// - needs to  be done in multiple places (code duplication).
// - may require information not accessible to the class that will use it.
//
// Advantages:
// - Objects created are referenced through a common interface.
// - Does not expose instantiation logic or type of object returned to client.
// - Improves flexibility, as object creation is delegated to the factory
//   method.
//
// Disadvantages:
// - Might add extra complexity to the implementation.
//
// Examples: NumberFormat, Calendar, ResourceBundle
//
// In the example below, an e-Commerce business has three ways of delivering
// orders to clients: PriorityDelivery, StandardDelivery and FreeDelivery. The
// type of delivery depends on the total value of the order, i.e. clients who
// spend more will receive their items faster. It also depends on whether the
// client has requested and paid for expedited delivery.
//
// The DeliveryFactory is responsible for implementing this logic and returning
// the concrete Delivery object that is most appropriate for each given order.
// The class using the factory does not care about which type of Delivery
// object has been returned, it just uses it based on the methods declared on
// the interface.

public class FactoryMethod {

    private static final DeliveryFactory DELIVERY_FACTORY =
        new DeliveryFactory(50.0, 100.0);

    private static final boolean testFreeDelivery() {
        Order order = new Order();
        order.add(new Product(375, "CheapTech Keyboard", 5), 1);
        Delivery delivery = DELIVERY_FACTORY.getDelivery(order);
        return delivery instanceof FreeDelivery;
    }

    private static final boolean testStandardDelivery() {
        Order order = new Order();
        order.add(new Product(375, "CheapTech Keyboard", 5), 12);
        Delivery delivery = DELIVERY_FACTORY.getDelivery(order);
        return delivery instanceof StandardDelivery;
    }
        
    private static final boolean testPriorityDelivery() {
        Order order = new Order();
        order.add(new Product(375, "CheapTech Keyboard", 5), 22);
        Delivery delivery = DELIVERY_FACTORY.getDelivery(order);
        return delivery instanceof PriorityDelivery;
    }

    private static final boolean testExpeditedDelivery() {
        Order order = new Order();
        order.add(new Product(375, "CheapTech Keyboard", 5), 1);
        order.setExpedited(true);
        Delivery delivery = DELIVERY_FACTORY.getDelivery(order);
        return delivery instanceof PriorityDelivery;
    }

    public static void main(String[] args) {
        int counter = 0;
        if (!testFreeDelivery()) {
            System.out.println("Free delivery test failed!");
            counter++;
        }
        if (!testStandardDelivery()) {
            System.out.println("Standard delivery test failed!");
            counter++;
        }
        if (!testPriorityDelivery()) {
            System.out.println("Priority delivery test failed!");
            counter++;
        }
        if (!testExpeditedDelivery()) {
            System.out.println("Expedited delivery test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

