public final class Response {

    public enum Type {
        APPROVED,
        REJECTED
    };

    private final Request request;
    private final Type type;
    private final String actionedBy;

    public Response(Request request, Type type, String actionedBy) {
        this.request = request;
        this.type = type;
        this.actionedBy = actionedBy;
    }

    public Request getRequest() {
        return request;
    }

    public Type getType() {
        return type;
    }

    public String getActionedBy() {
        return actionedBy;
    }
}

