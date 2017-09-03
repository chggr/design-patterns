// The flyweight pattern is a structural software design pattern that helps
// minimize memory use by sharing objects that need to be instantiated in large
// quantities. Flyweight objects must be immutable, so that they can be safely
// shared between clients and threads. Clients should never create Flyweight
// objects themselves, but instead use a Flyweight Factory for this purpose.
// The Flywieght Factory internally contains a repository of Flyweight objects
// and will reuse any objects that are already present in the repository.
//
// Advantages:
// - Reduces overall memory footprint.
//
// Disadvantages:
// - Often is used to optimize prematurely.
//
// Examples: String, Integer, Character, Short, Long
//
// In the example below we have an immutable Product class that contains
// information about a specific product. The expectation is that users will
// retrieve Products from the Catalog to add to their orders and that the same
// Product will be used multiple times throught the life of the application.
// In this case class Product is the Flyweight and class Catalog is the
// Flyweight Factory. Whenever a user requests a Product, Catalog will first
// search into its internal repository and return the same Product instance if
// found. Otherwise it will look up the Product in the ProductDatabase and
// insert it into the repository before returning it to the user. The end
// result is that only few instances of Product are created, but these are
// shared accross multiple orders as required.

public class Flyweight {

    private static boolean testCatalog_SameProduct() {
        Catalog catalog = new Catalog();
        Product jacket = catalog.getProduct(1);
        Product sameJacket = catalog.getProduct(1);
        return jacket == sameJacket;
    }

    private static boolean testCatalog_DifferentProduct() {
        Catalog catalog = new Catalog();
        Product jacket = catalog.getProduct(1);
        Product hat = catalog.getProduct(5);
        return hat != jacket;
    }

    private static boolean testCatalog_BadProductId() {
        Catalog catalog = new Catalog();
        return catalog.getProduct(10) == null;
    }

    public static void main(String[] args) {
        int counter = 0;
        if (!testCatalog_SameProduct()) {
            System.out.println("Same product catalog test failed!");
            counter++;
        }
        if (!testCatalog_DifferentProduct()) {
            System.out.println("Different product catalog test failed!");
            counter++;
        }
        if (!testCatalog_BadProductId()) {
            System.out.println("Bad product id catalog test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

