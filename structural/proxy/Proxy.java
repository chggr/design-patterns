// The proxy pattern is a structural software design pattern that can be used
// to wrap a real object within a proxy object that controls all access to it.
// The proxy class implements the same interface(s) as the real class, so that
// clients can use the proxy object instead of the real one seamlessly. The
// proxy can simply forward requests to the real object or provide additional
// functionality such as lazy initialization, access control, caching, etc.
//
// The proxy pattern is simple in concept but can be utilized in many different
// ways, especially in cases where an intermediary object is required to
// intercept calls to a real object and take appropriate actions. Some of the
// most popular usages of proxies are listed below:
//
// 1) Remote proxy: In distributed object communication, a local proxy object
// can be used to represent a remote object that belongs to a different address
// space on the same host or to a remote host. A method call on the local proxy
// results in a remote method invocation to the remote object.
//
// 2) Access control proxy: This type of proxy restricts unauthorized access to
// the real object.
//
// 3) Virtual proxy: Allows lazy loading of a complex or heavy object when and
// if required.
//
// 4) Caching proxy: Used when method calls on the real object are costly. The
// proxy caches results of the real method calls so that subsequent calls to
// the proxy can reuse the cached results.
//
// Advantages:
// - Suitable for use in many different scenarios.
// - In many cases leads to enhanced efficiency, lower costs and better security.
//
// Disadvantages:
// - Typically only one proxy is used per real class.
// - Adds one further layer of abstraction. Errors can come either from the
//   real class or from the proxy itself, so sometimes hard to debug.
//
// Examples: java.lang.reflect.Proxy, java.rmi.*
//
// In the example below we use a proxy to achieve two things: (1) capture
// metrics around method calls (total count and average duration) and (2) lazy
// object instantiation. The RemoteResource class defines a Resource that is
// very expensive to instantiate because it involves contacting a remote
// server and initializing the resource. In addition, we suspect that read and
// write operations are very slow, so we would like to measure and quantify
// their performance. Both things can be achieved via the RemoteResourceProxy
// class. Calls to read() and write() are intercepted, so that their
// performance can be measured. Moreover, if the client does not call read()
// and write() at all, the RemoteResource is never instantiated, thus saving
// us from paying the associated high cost.

public class Proxy {

    private static boolean testReadWrite() {
        final RemoteResourceProxy proxy = new RemoteResourceProxy();
        final ResourceUser resourceUser = new ResourceUser(proxy, 10, 10);
        resourceUser.readFromResource();
        resourceUser.writeToResource();

        return proxy.getReadCount() == 10 &&
               proxy.getWriteCount() == 10 &&
               proxy.getAverageReadDuration() > 0 &&
               proxy.getAverageWriteDuration() > 0;
    }

    private static boolean testReadNotWrite() {
        final RemoteResourceProxy proxy = new RemoteResourceProxy();
        final ResourceUser resourceUser = new ResourceUser(proxy, 10, 10);
        resourceUser.readFromResource();

        return proxy.getReadCount() == 10 &&
               proxy.getWriteCount() == 0 &&
               proxy.getAverageReadDuration() > 0 &&
               proxy.getAverageWriteDuration() == 0;
    }

    private static boolean testNotReadWrite() {
        final RemoteResourceProxy proxy = new RemoteResourceProxy();
        final ResourceUser resourceUser = new ResourceUser(proxy, 10, 10);
        resourceUser.writeToResource();

        return proxy.getReadCount() == 0 &&
               proxy.getWriteCount() == 10 &&
               proxy.getAverageReadDuration() == 0 &&
               proxy.getAverageWriteDuration() > 0;
    }

    private static boolean testNotReadNotWrite() {
        final RemoteResourceProxy proxy = new RemoteResourceProxy();
        final ResourceUser resourceUser = new ResourceUser(proxy, 10, 10);

        return proxy.getReadCount() == 0 &&
               proxy.getWriteCount() == 0 &&
               proxy.getAverageReadDuration() == 0 &&
               proxy.getAverageWriteDuration() == 0;
    }

    public static void main(String[] args) {
        int counter = 0;
        if (!testReadWrite()) {
            System.out.println("Read and write to resource test failed!");
            counter++;
        }
        if (!testReadNotWrite()) {
            System.out.println("Read but not write to resource test failed!");
            counter++;
        }
        if (!testNotReadWrite()) {
            System.out.println("Not Read but write to resource test failed!");
            counter++;
        }
        if (!testNotReadNotWrite()) {
            System.out.println("Not read and not write to resource test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

