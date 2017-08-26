// The singleton pattern is a creational software design pattern that restricts
// instantiation of a class to just one object. This can be useful for example
// in cases where only one object should handle access to a specific resource
// across the application. Singletons typically expose a static getInstance()
// method that does not accept any parameters and allows clients to retrieve
// the single instance.
//
// Advantages:
// - Guarantees there is only a single global instance of a class.
// - Easy to implement and make thread safe.
//
// Disadvantages:
// - Hides dependencies instead of exposing them through interfaces.
// - Difficult to unit test (maintains state across tests / cannot be mocked).
// - Often abused and overused.
//
// Examples: Runtime, Spring Beans, Graphics Managers 
//
// There are multiple ways to implement a singleton in Java, as demonstrated in
// the examples below:
//
// 1) Eager initialization (WindowManager)
//    In this case the singleton instance is created eagerly upon application
//    startup. The singleton class should be made final in all cases, to
//    prevent clients from extending it and thus creating more than one objects.
//
// 2) Lazy initialization (DatabaseConnectionManager)
//    There are many cases where a singleton instance is not required at
//    application startup or might not be required at all in its lifetime. In
//    such cases it is often desirable to lazily initialize the singleton
//    instance only when necessary. This can be done inside the getInstance()
//    method before the instance is returned. Double-checked locking should
//    be used and the instance needs to be declared as volatile to ensure
//    thread safety. 
//
// 3) Using enums (ResourceManager)
//    An elegant way to create a singleton in Java is by converting the class
//    to enum. This method ensures that only one instance is available in the
//    application and it is totally thread safe.
//
// 4) Singleton interface implementations (Loggers)
//    Sometimes we need to ensure all implementations of a particular interface
//    are singletons. An easy and safe way to do this is by using enums, as
//    shown in the Loggers example. There are three Loggers defined and only
//    one instance of each should be available in the application. This can be
//    achieved by defining the enum to implement the interface.

public class Singleton {

    private static boolean testDatabaseConnectionManager() {
        return DatabaseConnectionManager.getInstance() == 
               DatabaseConnectionManager.getInstance();
    }

    private static boolean testWindowManager() {
        return WindowManager.getInstance() == WindowManager.getInstance();
    } 

    public static void main(String[] args) {
        int counter = 0;
        if (!testDatabaseConnectionManager()) {
            System.out.println("DatabaseConnectionManager test failed!");
            counter++;
        }
        if (!testWindowManager()) {
            System.out.println("WindowManager test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

