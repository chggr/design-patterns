public abstract class AbstractRequestHandler implements RequestHandler {

    private final String name;
    private final int threshold;
    private final RequestHandler successor;
    
    public AbstractRequestHandler(String name,
                                  int threshold,
                                  RequestHandler successor) {
        this.name = name;
        this.threshold = threshold;
        this.successor = successor;
    }

    @Override
    public Response handle(Request request) {
        final Response.Type decision = examine(request);
        return decision == null ?
            successor.handle(request) : 
            new Response(request, decision, name);
    }

    abstract Response.Type examine(Request request);

    public String getName() {
        return this.name;
    }

    public int getThreshold() {
        return this.threshold;
    }
}

