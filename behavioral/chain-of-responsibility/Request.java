public final class Request {

    private final int id;
    private final int value;
    private final String description;

    public Request(int id, int value, String description) {
        this.id = id;
        this.value = value;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}


