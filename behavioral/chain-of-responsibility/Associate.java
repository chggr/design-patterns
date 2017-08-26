public class Associate extends AbstractRequestHandler {

    public Associate(String name, int threshold, RequestHandler successor) {
        super(name, threshold, successor);
    }

    @Override
    Response.Type examine(Request request) {
        return request.getValue() <= getThreshold() ?
            Response.Type.APPROVED : null;
    }
}

