package chain;

/**
 * Created by liju on 5/24/16.
 */
public class RequestHandlerB extends RequestHandler {

    public RequestHandlerB(RequestHandler requestHandler) {
        super(requestHandler);
    }

    @Override
    public void handleRequest(Request request) {
        System.out.println("Request handler B  - called");
        if (request.getType() == RequestType.B) {
            printRequest(request);
        } else {
            super.handleRequest(request);
        }
    }

    @Override
    public void printRequest(Request request) {
        request.setRequestHandled(true);
        System.out.println("Request processed by handle - B");
        System.out.println("Request - " + request.toString());
    }
}
