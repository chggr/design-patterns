public class ManagingDirector extends AbstractRequestHandler {

    public ManagingDirector(String name, int threshold, RequestHandler successor) {
        super(name, threshold, successor);
    }

    @Override
    Response.Type examine(Request request) {
        return request.getValue() <= getThreshold() ?
            Response.Type.APPROVED : Response.Type.REJECTED;
    }
}

