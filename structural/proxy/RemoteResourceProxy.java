public final class RemoteResourceProxy implements Resource {

    private RemoteResource remote;

    private int readCount = 0;
    private long readDuration = 0;

    private int writeCount = 0;
    private long writeDuration = 0;

    @Override
    public synchronized String read() {
        if (remote == null) {
            remote = new RemoteResource();
        }

        long start = System.nanoTime();
        String data = remote.read();
        readDuration += System.nanoTime() - start;
        readCount++;

        return data;
    }

    @Override
    public void write(String data) {
        if (remote == null) {
            remote = new RemoteResource();
        }

        long start = System.nanoTime();
        remote.write(data);
        writeDuration += System.nanoTime() - start;
        writeCount++;
    }

    public int getReadCount() {
        return readCount;
    }

    public long getAverageReadDuration() {
        return readCount == 0 ? 0 : readDuration / readCount;
    }

    public int getWriteCount() {
        return writeCount;
    }

    public long getAverageWriteDuration() {
        return writeCount == 0 ? 0 : writeDuration / writeCount;
    }
}

