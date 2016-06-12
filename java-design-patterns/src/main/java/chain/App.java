package chain;

/**
 * Created by liju on 5/24/16.
 */
public class App {

    public static void main(String[] args) {
        Request request = new Request(RequestType.B);
        request.setPayload("hello world");

        RequestHandler chain = new RequestHandlerB(new RequestHandlerA(new RequestHandlerC(null)));
        chain.handleRequest(request);
    }
}
