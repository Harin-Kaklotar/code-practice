package chain;

/**
 * Created by liju on 5/24/16.
 */
public class RequestHandlerA extends RequestHandler {

    public RequestHandlerA(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handleRequest(Request request) {
        System.out.println("Request handler A  - called");
        if (request.getType() == RequestType.A) {
            printRequest(request);
        } else {
            super.handleRequest(request);
        }
    }

    @Override
    public void printRequest(Request request) {
        request.setRequestHandled(true);
        System.out.println("Request processed by handle - A");
        System.out.println("Request - " + request.toString());
    }
}
