import java.util.NoSuchElementException;

// The iterator pattern is a behavioral software design pattern that provides a
// way to access the elements of a container sequentially without exposing its
// underlying representation. The responsibility for traversing the contents is
// taken out of the container and put into a separate Iterator class that
// complies with a standard traversal protocol. Thus traversing different
// container types (array, tree, hash table, linked list, etc) is done in a
// similar way and algorithms can be defined to interface with each container
// transparently.
//
// Advantages:
// - Decouples algorithms from containers.
// - Does not expose the underlying container structure.
//
// Disadvantages:
// - In most cases it only supports unidirectional access.
//
// Examples: Iterator, Enumeration
//
// In the example below, the CircularBuffer class implements the standard Java
// Iterable interface to enable the client to use for-each loops to access its
// elements. It supports read / write operations and automatic resizing. 

public class Iterator {

    private static boolean testSize() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>();
        buffer.write(1);
        buffer.write(2);
        return buffer.size() == 2;
    }

    private static boolean testSize_EmptyBuffer() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>();
        return buffer.size() == 0;
    }

    private static boolean testRead() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>();
        buffer.write(1);
        buffer.write(2);
        return buffer.read() == 1 && buffer.read() == 2;
    }

    private static boolean testRead_EmptyBuffer() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>();
        try {
            buffer.read();
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }

    private static boolean testWrite_BufferResize() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(10);
        for (int i = 0; i < 100; i++) {
            buffer.write(i);
        }

        boolean testResult = true;
        for (int i = 0; i < 100; i++) {
            testResult = testResult && buffer.read() == i;
        }
        return testResult;
    }

    private static boolean testReadWrite_BufferCycles() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(10);
        boolean testResult = true;
        for (int i = 0; i < 100; i++) {
            buffer.write(i);
            testResult = testResult && buffer.read() == i;
        }
        return testResult;
    }

    private static boolean testIterator_HasNext_EmptyBuffer() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>();
        return !buffer.iterator().hasNext();
    }

    private static boolean testIterator_HasNext() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>();
        buffer.write(1);
        return buffer.iterator().hasNext();
    }

    private static boolean testIterator_Next_EmptyBuffer() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>();
        try {
            buffer.iterator().next();
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }

    private static boolean testIterator_Next() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>();
        buffer.write(1);
        return buffer.iterator().next() == 1;
    }

    private static boolean testIterator_ForEach() {
        CircularBuffer<Integer> buffer = new CircularBuffer<>(10);
        for (int i = 0; i < 100; i++) {
            buffer.write(i);
        }

        int counter = 0;
        boolean testResult = true;
        for (Integer element : buffer) {
            testResult = testResult && element == counter++;
        }
        return testResult;
    }

    public static void main(String[] args) {
        int counter = 0;
        if (!testSize()) {
            System.out.println("Size test failed!");
            counter++;
        }
        if (!testSize_EmptyBuffer()) {
            System.out.println("Empty buffer size test failed!");
            counter++;
        }
        if (!testRead()) {
            System.out.println("Read test failed!");
            counter++;
        }
        if (!testRead_EmptyBuffer()) {
            System.out.println("Empty buffer read test failed!");
            counter++;
        }
        if (!testWrite_BufferResize()) {
            System.out.println("Buffer resize write test failed!");
            counter++;
        }
        if (!testReadWrite_BufferCycles()) {
            System.out.println("Buffer cycle read write test failed!");
            counter++;
        }
        if (!testIterator_HasNext_EmptyBuffer()) {
            System.out.println("Has next empty buffer iterator test failed!");
            counter++;
        }
        if (!testIterator_HasNext()) {
            System.out.println("Has next iterator test failed!");
            counter++;
        }
        if (!testIterator_Next_EmptyBuffer()) {
            System.out.println("Next empty buffer iterator test failed!");
            counter++;
        }
        if (!testIterator_Next()) {
            System.out.println("Next iterator test failed!");
            counter++;
        }
        if (!testIterator_ForEach()) {
            System.out.println("For each iterator test failed!");
            counter++;
        }
        System.out.println(counter + " tests failed.");
    }
}

