public final class ResourceUser {

    final Resource resource;
    final int readCount;
    final int writeCount;

    public ResourceUser(Resource resource, int readCount, int writeCount) {
        this.resource = resource;
        this.readCount = readCount;
        this.writeCount = writeCount;
    }

    public void readFromResource() {
        for (int i = 0; i < readCount; i++) {
            resource.read();
        }
    }

    public void writeToResource() {
        for (int i = 0; i < writeCount; i++) {
            resource.write("data");
        }
    }
}

