import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularBuffer<T> implements Iterable<T> {

    private T[] buffer;
    private int start = 0;
    private int end = 0;

    public CircularBuffer(int size) {
        buffer = (T[]) new Object[size];
    }

    public CircularBuffer() {
        buffer = (T[]) new Object[8];
    }

    public int size() {
        return end - start;
    }

    public T read() {
        if (end <= start) {
            throw new NoSuchElementException();
        }
        T value = buffer[start++ % buffer.length];
        removeOffset();
        return value;
    }

    public void write(T item) {
        resize();
        buffer[end++ % buffer.length] = item;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = start;

            public T next() {
                if (cursor >= end) {
                    throw new NoSuchElementException();
                }
                return buffer[cursor++ % buffer.length];
            }

            public boolean hasNext() {
                return end - cursor > 0;
            }
        };
    }

    private void resize() {
        T[] newBuffer = null;

        if ((end - start) >= buffer.length) {
            newBuffer = (T[]) new Object[buffer.length * 2];
        } else if ((end - start) < (buffer.length / 4) && buffer.length > 8) {
            newBuffer = (T[]) new Object[buffer.length / 2];
        }

        if (newBuffer != null) {
            for (int i = 0; i < (end - start); i++) {
                newBuffer[i] = buffer[start + i];
            }
            buffer = newBuffer;
        }
    }

    private void removeOffset() {
        int offset = start / buffer.length;
        start -= offset * buffer.length;
        end -= offset * buffer.length;
    }
}

