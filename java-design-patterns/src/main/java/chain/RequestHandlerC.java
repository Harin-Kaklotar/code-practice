package chain;

/**
 * Created by liju on 5/24/16.
 */
public class RequestHandlerC extends RequestHandler {

    public RequestHandlerC(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handleRequest(Request request) {
        System.out.println("Request handler C  - called");
        if (request.getType() == RequestType.C) {
            printRequest(request);
        } else {
            super.handleRequest(request);
        }
    }

    @Override
    public void printRequest(Request request) {
        request.setRequestHandled(true);
        System.out.println("Request processed by handle - C");
        System.out.println("Request - " + request.toString());
    }
}
