public final class NetworkUsage {

    public enum Type {
        CALL, TEXT, DATA
    };

    private final Type type;
    private final int units;

    public NetworkUsage(Type type, int units) {
        this.type = type;
        this.units = units;
    }

    public Type getType() {
        return this.type;
    }

    public int getUnits() {
        return this.units;
    }
}

