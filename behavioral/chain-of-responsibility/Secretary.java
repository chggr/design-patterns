public class Secretary extends AbstractRequestHandler {

    public Secretary(String name, int threshold, RequestHandler successor) {
        super(name, threshold, successor);
    }

    @Override
    Response.Type examine(Request request) {
        final String description = request.getDescription();
        if (description == null || description.isEmpty()) {
            return Response.Type.REJECTED;
        }
        return request.getValue() <= getThreshold() ?
            Response.Type.APPROVED : null;
    }
}
