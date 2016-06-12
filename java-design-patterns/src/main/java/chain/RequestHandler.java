package chain;

/**
 * Created by liju on 5/24/16.
 */
public abstract class RequestHandler {
    private RequestHandler next;

    public RequestHandler(RequestHandler requestHandler) {
        this.next = requestHandler;
    }

    public void handleRequest(Request request) {
        if (next != null) {
            next.handleRequest(request);
        }
    }

    public void printRequest(Request request) {
        System.out.println(request.toString());
    }
}
