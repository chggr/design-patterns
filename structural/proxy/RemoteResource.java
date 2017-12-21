public final class RemoteResource implements Resource {

    public RemoteResource() {
        // Expensive constructor.
        // Establishes connection to remote host and initializes resource.
    }

    @Override
    public String read() {
        return "data";
    }

    @Override
    public void write(String data) {
    }
}

